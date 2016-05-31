package com.satikey.tools.supervisord.exceptions;

/**
 * The exception is thrown whenever the remote procedure call fails in some point.
 *
 * @author Tim Roes
 * @see https://github.com/gturri/aXMLRPC/blob/master/src/main/java/de/timroes/axmlrpc/XMLRPCException.java
 */
public class XMLRPCException extends RuntimeException {

    public XMLRPCException() {
        super();
    }

    public XMLRPCException(Exception ex) {
        super(ex);
    }

    public XMLRPCException(String ex) {
        super(ex);
    }

    public XMLRPCException(String msg, Exception ex) {
        super(msg, ex);
    }

}