package com.satikey.tools.supervisord;

/**
 * @author Lei Duan(satifanie@gmail.com) .
 */
public class Supervisord {

    public static Supervisord connect() {

        return new Supervisord();
    }

    /**
     * Return the version of the RPC API used by supervisord
     *
     * @return string version version id
     */
    String getAPIVersion() {
        return null;
    }

    /**
     * Return the version of the supervisor package in use by supervisord
     *
     * @return string version version id
     */
    String getSupervisorVersion() {
        return null;
    }

    /**
     * Return identifying string of supervisord
     *
     * @return string identifier identifying string
     */
    public String getIdentification() {
        return null;
    }

    /**
     * {'statecode': 1, 'statename': 'RUNNING'} Return current state of supervisord as a struct
     *
     * @return struct A struct with keys int statecode, string statename
     */
    public String getState() {
        return null;

    }

    /**
     * Return the PID of supervisord
     *
     * @return int PID
     */
    public int getPID() {
        return -1;
    }

    /**
     * Read length bytes from the main log starting at offset
     *
     * @param offset offset to start reading from
     * @param length number of bytes to read from the log.
     * @return string result Bytes of log*
     * @see http://supervisord.org/api.html#supervisor.rpcinterface.SupervisorNamespaceRPCInterface.readLog
     */
    public String readLog(int offset, int length) {
        return null;
    }

    /**
     * Clear the main log.
     *
     * @return boolean result always returns True unless error
     */
    public boolean clearLog() {
        return true;
    }

    /**
     * Shut down the supervisor process
     *
     * @return boolean result always returns True unless error
     */
    public boolean shutdown() {
        return true;
    }

    /**
     * Restart the supervisor process
     *
     * @return boolean result always return True unless error
     */
    public boolean restart() {
        return false;
    }

    /////
    void listMethods() {
    }

    void methodHelp(String method) {
    }

    void multicall(Object[] calls) {
    }

    void clearAllProcessLogs() {
    }

    void clearProcessLogs(String processName) {
    }

    void tailProcessStderrLog(String name, int offset, int length) {
    }

    void tailProcessStdoutLog(String name, int offset, int length) {
    }

}
