package com.satikey.tools.supervisord;

import com.satikey.tools.supervisord.exceptions.XMLRPCException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * The ResponseParser parses the response of an XMLRPC server to an object.
 *
 * @author Tim Roes
 * @since 1.6
 */
class ResponseParser {
    private enum TYPE {
        I4, INT, STRING, BOOLEAN, DOUBLE, STRUCT, ARRAY
    }

    private static final String FAULT_CODE = "faultCode";
    private static final String FAULT_STRING = "faultString";

    private static final String METHOD_RESPONSE = "methodResponse";
    private static final String PARAMS = "params";
    private static final String PARAM = "param";
    public static final String VALUE = "value";
    private static final String FAULT = "fault";
    private static final String METHOD_CALL = "methodCall";
    private static final String METHOD_NAME = "methodName";
    private static final String STRUCT_MEMBER = "member";


    Object parse(InputStream xmlin) throws XMLRPCException {
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document dom = builder.parse(xmlin);

            Element e = dom.getDocumentElement();


            // Check for root tag
            if (!e.getNodeName().equals(METHOD_RESPONSE)) {
                throw new XMLRPCException("MethodResponse root tag is missing.");
            }
            //ROOT
            e = getOnlyChildElement(e.getChildNodes());

            if (e.getNodeName().equals(PARAMS)) {
                //PARAMS
                e = getOnlyChildElement(e.getChildNodes());
                if (!e.getNodeName().equals(PARAM)) {
                    throw new XMLRPCException("The params tag must contain a param tag.");
                }
                //parse value
                return getReturnValueFromElement(e);
            } else if (e.getNodeName().equals(FAULT)) {

                @SuppressWarnings("unchecked")
                Map<String, Object> o = (Map<String, Object>) getReturnValueFromElement(e);
                throw new XMLRPCException((String) o.get(FAULT_STRING) + ":" + (Integer) o.get(FAULT_CODE));

            }

            throw new XMLRPCException("The methodResponse tag must contain a fault or params tag.");

        } catch (XMLRPCException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new XMLRPCException("Error getting result from server.", ex);
        }
    }

    public static void printDocument(Document doc, OutputStream out) throws IOException, TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        transformer.transform(new DOMSource(doc),
                new StreamResult(new OutputStreamWriter(out, "UTF-8")));
    }

    /**
     * This method takes an element (must be a param or fault element) and returns the deserialized
     * object of this param tag.
     *
     * @param element An param element.
     * @return The deserialized object within the given param element.
     * @throws XMLRPCException Will be thrown when the structure of the document doesn't match the
     *                         XML-RPC specification.
     */
    private Object getReturnValueFromElement(Element element) {
        Element childElement = getOnlyChildElement(element.getChildNodes());
        return extract(childElement);
    }

    private Object extract(Element element) {
        Element childElement = getOnlyChildElement(element.getChildNodes());
        String nodeName = childElement.getNodeName();
        TYPE type = TYPE.valueOf(nodeName.toUpperCase());
        switch (type) {
            case INT:
                return extractInt(childElement);
            case BOOLEAN:
                return true;
            case STRING:
                return extractString(childElement);
            case STRUCT:
                return extractStruct(childElement);
            case ARRAY:
                return extractArray(childElement);
            default:
                return 0;
        }
    }

    private String extractString(Element content) throws XMLRPCException {
        String text = getOnlyTextContent(content.getChildNodes());
        text = text.replaceAll("&lt;", "<").replaceAll("&amp;", "&");
        return text;
    }

    private int extractInt(Element content) {
        return Integer.parseInt(getOnlyTextContent(content.getChildNodes()));
    }

    private boolean extractBoolean(Element content) {
        return getOnlyTextContent(content.getChildNodes()).equals("1")
                ? Boolean.TRUE : Boolean.FALSE;
    }

    private Object extractStruct(Element content) {
        final String STRUCT_MEMBER = "member";
        final String STRUCT_NAME = "name";
        final String STRUCT_VALUE = "value";

        Map<String, Object> map = new HashMap<String, Object>();

        Node n, m;
        String s;
        Object o;
        for (int i = 0; i < content.getChildNodes().getLength(); i++) {

            n = content.getChildNodes().item(i);

            // Strip only whitespace text elements and comments
            if ((n.getNodeType() == Node.TEXT_NODE
                    && n.getNodeValue().trim().length() <= 0)
                    || n.getNodeType() == Node.COMMENT_NODE)
                continue;

            if (n.getNodeType() != Node.ELEMENT_NODE
                    || !STRUCT_MEMBER.equals(n.getNodeName())) {
                throw new XMLRPCException("Only struct members allowed within a struct.");
            }

            // Grep name and value from member
            s = null;
            o = null;
            for (int j = 0; j < n.getChildNodes().getLength(); j++) {
                m = n.getChildNodes().item(j);

                // Strip only whitespace text elements and comments
                if ((m.getNodeType() == Node.TEXT_NODE
                        && m.getNodeValue().trim().length() <= 0)
                        || m.getNodeType() == Node.COMMENT_NODE)
                    continue;

                if (STRUCT_NAME.equals(m.getNodeName())) {
                    if (s != null) {
                        throw new XMLRPCException("Name of a struct member cannot be set twice.");
                    } else {
                        s = getOnlyTextContent(m.getChildNodes());
                    }
                } else if (m.getNodeType() == Node.ELEMENT_NODE && STRUCT_VALUE.equals(m.getNodeName())) {
                    if (o != null) {
                        throw new XMLRPCException("Value of a struct member cannot be set twice.");
                    } else {
                        o = extract((Element) m);
                    }
                } else {
                    throw new XMLRPCException("A struct member must only contain one name and one value.");
                }

            }

            map.put(s, o);

        }

        return map;
    }

    private Object[] extractArray(Element content) {
        final String ARRAY_DATA = "data";
        final String ARRAY_VALUE = "value";
        List<Object> list = new ArrayList<Object>();

        Element data = getOnlyChildElement(content.getChildNodes());

        if (!ARRAY_DATA.equals(data.getNodeName())) {
            throw new XMLRPCException("The array must contain one data tag.");
        }

        // Deserialize every array element
        Node value;
        for (int i = 0; i < data.getChildNodes().getLength(); i++) {

            value = data.getChildNodes().item(i);

            // Strip only whitespace text elements and comments
            if (value == null || (value.getNodeType() == Node.TEXT_NODE
                    && value.getNodeValue().trim().length() <= 0)
                    || value.getNodeType() == Node.COMMENT_NODE)
                continue;

            if (value.getNodeType() != Node.ELEMENT_NODE) {
                throw new XMLRPCException("Wrong element inside of array.");
            }

            list.add(extract((Element) value));

        }

        return list.toArray();
    }

    /**
     * Returns the only child element in a given NodeList. Will throw an error if there is more then
     * one child element or any other child that is not an element or an empty text string
     * (whitespace are normal).
     *
     * @param list A NodeList of children nodes.
     * @return The only child element in the given node list.
     * @throws XMLRPCException Will be thrown if there is more then one child element except empty
     *                         text nodes.
     */
    private static Element getOnlyChildElement(NodeList list) throws XMLRPCException {

        Element e = null;
        Node n;
        for (int i = 0; i < list.getLength(); i++) {
            n = list.item(i);
            // Strip only whitespace text elements and comments
            if ((n.getNodeType() == Node.TEXT_NODE
                    && n.getNodeValue().trim().length() <= 0)
                    || n.getNodeType() == Node.COMMENT_NODE)
                continue;

            // Check if there is anything else than an element node.
            if (n.getNodeType() != Node.ELEMENT_NODE) {
                throw new XMLRPCException("Only element nodes allowed.");
            }

            // If there was already an element, throw exception.
            if (e != null) {
                throw new XMLRPCException("Element has more than one children.");
            }

            e = (Element) n;

        }

        return e;

    }

    /**
     * Returns the text node from a given NodeList. If the list contains more then just text nodes,
     * an exception will be thrown.
     *
     * @param list The given list of nodes.
     * @return The text of the given node list.
     * @throws XMLRPCException Will be thrown if there is more than just one text node within the
     *                         list.
     */
    private static String getOnlyTextContent(NodeList list) throws XMLRPCException {

        StringBuilder builder = new StringBuilder();
        Node n;

        for (int i = 0; i < list.getLength(); i++) {
            n = list.item(i);

            // Skip comments inside text tag.
            if (n.getNodeType() == Node.COMMENT_NODE) {
                continue;
            }

            if (n.getNodeType() != Node.TEXT_NODE) {
                throw new XMLRPCException("Element must contain only text elements.");
            }

            builder.append(n.getNodeValue());

        }

        return builder.toString();

    }

    /**
     * Checks if the given {@link NodeList} contains a child element.
     *
     * @param list The {@link NodeList} to check.
     * @return Whether the {@link NodeList} contains children.
     */
    public static boolean hasChildElement(NodeList list) {

        Node n;

        for (int i = 0; i < list.getLength(); i++) {
            n = list.item(i);

            if (n.getNodeType() == Node.ELEMENT_NODE) {
                return true;
            }
        }

        return false;

    }
}
