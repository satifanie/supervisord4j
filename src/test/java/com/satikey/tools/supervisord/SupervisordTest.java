package com.satikey.tools.supervisord;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.util.Properties;

/**
 * Supervisord Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 31, 2016</pre>
 */
@FixMethodOrder(MethodSorters.JVM)
public class SupervisordTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(SupervisordTest.class);
    private Supervisord supervisord;

    @Before
    public void before() throws Exception {
        Properties prop = new Properties();
        String configFilePath = SupervisordTest.class.getClassLoader().getResource("config.properties").getFile();
        prop.load(new FileReader(configFilePath));
        String api = prop.getProperty("api.url");
        String userName = prop.getProperty("api.username");
        String password = prop.getProperty("api.password");
        supervisord = Supervisord
                .connect(api)
                .auth(userName, password);

    }

    @After
    public void after() throws Exception {
    }


    /**
     * Method: getIdentification()
     */
    @Test
    public void testGetIdentification() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getState()
     */
    @Test
    public void testGetState() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getPID()
     */
    @Test
    public void testGetPID() throws Exception {
    }

    /**
     * Method: readLog(int offset, int length)
     */
    @Test
    public void testReadLog() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: clearLog()
     */
    @Test
    public void testClearLog() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: shutdown()
     */
    @Test
    public void testShutdown() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: restart()
     */
    @Test
    public void testRestart() throws Exception {
//TODO: Test goes here... 
    }


    /**
     * Method: methodHelp(String method)
     */
    @Test
    public void testMethodHelp() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: multicall(Object[] calls)
     */
    @Test
    public void testMulticall() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getProcessInfo(String processName)
     */
    @Test
    public void testGetProcessInfo() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getAllProcessInfo()
     */
    @Test
    public void testGetAllProcessInfo() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: startProcess(String processName, boolean waitToStart)
     */
    @Test
    public void testStartProcess() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: startAllProcesses(boolean waitToStart)
     */
    @Test
    public void testStartAllProcesses() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: startProcessGroup(String groupName, boolean waitToStart)
     */
    @Test
    public void testStartProcessGroup() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: stopProcess(String processName, boolean waitToStop)
     */
    @Test
    public void testStopProcess() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: stopProcessGroup(String groupName, boolean waitToStop)
     */
    @Test
    public void testStopProcessGroup() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: stopAllProcesses(boolean waitToStop)
     */
    @Test
    public void testStopAllProcesses() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: signalProcess(String processName, String signal)
     */
    @Test
    public void testSignalProcess() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: signalProcessGroup(String groupName, String signal)
     */
    @Test
    public void testSignalProcessGroup() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: signalAllProcesses(String signal)
     */
    @Test
    public void testSignalAllProcesses() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: sendProcessStdin(String processName, String chars)
     */
    @Test
    public void testSendProcessStdin() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: sendRemoteCommEvent(String type, String data)
     */
    @Test
    public void testSendRemoteCommEvent() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: reloadConfig()
     */
    @Test
    public void testReloadConfig() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: addProcessGroup(String name)
     */
    @Test
    public void testAddProcessGroup() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: removeProcessGroup(String name)
     */
    @Test
    public void testRemoveProcessGroup() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: readProcessStdoutLog(String name, int offset, int length)
     */
    @Test
    public void testReadProcessStdoutLog() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: readProcessStderrLog(String name, int offset, int length)
     */
    @Test
    public void testReadProcessStderrLog() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: tailProcessStdoutLog(String name, int offset, int length)
     */
    @Test
    public void testTailProcessStdoutLog() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: tailProcessStderrLog(String name, int offset, int length)
     */
    @Test
    public void testTailProcessStderrLog() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: clearProcessLogs(String name)
     */
    @Test
    public void testClearProcessLogs() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: clearAllProcessLogs()
     */
    @Test
    public void testClearAllProcessLogs() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: call(String methodName, Object... args)
     */
    @Test
    public void testCall() throws Exception {
//TODO: Test goes here... 
    }


    /**
     * Method: post(String xml)
     */
    @Test
    public void testPost() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = Supervisord.getClass().getMethod("post", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: buildCall(String method, Object... params)
     */
    @Test
    public void testBuildCall() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = Supervisord.getClass().getMethod("buildCall", String.class, Object....class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }


    /**
     * Method: getAPIVersion()
     */
    @Test
    public void testGetAPIVersion() throws Exception {
        LOGGER.info("testing getAPIVersion:");
        String version = supervisord.getAPIVersion();
        LOGGER.info("version:{}", version);
    }

    /**
     * Method: getSupervisorVersion()
     */
    @Test
    public void testGetSupervisorVersion() throws Exception {
        LOGGER.info("testing getSupervisorVersion:");
        String version = supervisord.getSupervisorVersion();
        LOGGER.info("supervisror version:{}", version);
    }

    /**
     * Method: listMethods()
     */
    @Test
    public void testListMethods() throws Exception {
        LOGGER.info("testing listMethods:");
        Object[] datas = supervisord.listMethods();
        int num = 0;
        for (Object item : datas) {
            LOGGER.info("{}.{}", ++num, item);
        }
    }

} 
