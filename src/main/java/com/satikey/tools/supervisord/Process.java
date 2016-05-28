package com.satikey.tools.supervisord;

/**
 * @author Lei Duan(satifanie@gmail.com) .
 */
public class Process {
//{'name':           'process name',
//'group':          'group name',
//'description':    'pid 18806, uptime 0:03:12'
//'start':          1200361776,
//'stop':           0,
//'now':            1200361812,
//'state':          1,
//'statename':      'RUNNING',
//'spawnerr':       '',
//'exitstatus':     0,
//'logfile':        '/path/to/stdout-log', # deprecated, b/c only
//'stdout_logfile': '/path/to/stdout-log',
//'stderr_logfile': '/path/to/stderr-log',
//'pid':            1}

    /**
     * Get info about a process named name
     *
     * @param processName name The name of the process (or ‘group:name’) @return struct result A
     *                    structure containing data about the process
     * @return string {@link http://supervisord.org/api.html#supervisor.rpcinterface.SupervisorNamespaceRPCInterface.getProcessInfo}
     */
    public String getProcessInfo(String processName) {
        return null;
    }

    /**
     * Get info about all processes
     *
     * @return array result An array of process status results
     */
    public String getAllProcessInfo() {
        return null;
    }

    /**
     * Start a process
     *
     * @param processName name Process name (or group:name, or group:*)
     * @param waitToStart wait Wait for process to be fully started
     * @return boolean result Always true unless error
     */
    public boolean startProcess(String processName, boolean waitToStart) {
        return true;
    }

    /**
     * Start all processes listed in the configuration file
     *
     * @param waitToStart wait Wait for each process to be fully started
     * @return array result An array of process status info structs
     */
    public void startAllProcesses(boolean waitToStart) {
    }

    /**
     * Start all processes in the group named ‘name’
     *
     * @param groupName   name The group name
     * @param waitToStart wait Wait for each process to be fully started
     * @return array result An array of process status info structs
     */
    public boolean startProcessGroup(String groupName, boolean waitToStart) {
        return true;
    }

    /**
     * Stop a process named by name
     *
     * @param processName name The name of the process to stop (or ‘group:name’)
     * @param waitToStop  wait Wait for the process to be fully stopped
     * @return boolean result Always return True unless error
     */
    public boolean stopProcess(String processName, boolean waitToStop) {
        return true;
    }

    /**
     * Stop all processes in the process group named ‘name’
     *
     * @param groupName  name The group name
     * @param waitToStop wait Wait for each process to be fully stopped
     * @return array result An array of process status info structs
     */
    public boolean stopProcessGroup(String groupName, boolean waitToStop) {
        return true;
    }

    /**
     * Stop all processes in the process list
     *
     * @param waitToStop wait Wait for each process to be fully stopped
     * @return array result An array of process status info structs
     */
    public boolean stopAllProcesses(boolean waitToStop) {
        return true;
    }

    /**
     * Send an arbitrary UNIX signal to the process named by name
     *
     * @param processName name Name of the process to signal (or ‘group:name’)
     * @param signal      signal Signal to send, as name (‘HUP’) or number (‘1’)
     */
    public boolean signalProcess(String processName, String signal) {
        return true;
    }

    /**
     * Send a signal to all processes in the group named ‘name’
     *
     * @param groupName name The group name
     * @param signal    signal Signal to send, as name (‘HUP’) or number (‘1’)
     * @return array
     */
    public boolean signalProcessGroup(String groupName, String signal) {
        return true;
    }


    /**
     * Send a signal to all processes in the process list
     *
     * @param signal signal Signal to send, as name (‘HUP’) or number (‘1’)
     * @return array An array of process status info structs
     */
    public boolean signalAllProcesses(String signal) {
        return true;
    }

    /**
     * Send a string of chars to the stdin of the process name. If non-7-bit data is sent (unicode),
     * it is encoded to utf-8 before being sent to the process’ stdin. If chars is not a string or
     * is not unicode, raise INCORRECT_PARAMETERS. If the process is not running, raise NOT_RUNNING.
     * If the process’ stdin cannot accept input (e.g. it was closed by the child process), raise
     * NO_FILE.
     *
     * @param processName name The process name to send to (or ‘group:name’)
     * @param chars       The character data to send to the process
     * @return boolean result Always return True unless error
     */
    public boolean sendProcessStdin(String processName, String chars) {
        return true;
    }


    /**
     * Send an event that will be received by event listener subprocesses subscribing to the
     * RemoteCommunicationEvent.
     *
     * @param type type String for the “type” key in the event header
     * @param data Data for the event body
     * @return boolean Always return True unless error
     */
    public boolean sendRemoteCommEvent(String type, String data) {
        return true;
    }

    /**
     * Reload configuration
     *
     * @return boolean result always return True unless error
     */
    public boolean reloadConfig() {
        return true;
    }


    /**
     * Update the config for a running process from config file.
     *
     * @param name name name of process group to add
     * @return boolean result true if successful
     */
    public boolean addProcessGroup(String name) {
        return true;
    }


    /**
     * Remove a stopped process from the active configuration.
     *
     * @param name name of process group to remove
     * @return boolean result Indicates whether the removal was successful
     */
    public boolean removeProcessGroup(String name) {
        return true;
    }

    ////////////////////

    /**
     * Read length bytes from name’s stdout log starting at offset
     *
     * @param name   the name of the process (or ‘group:name’)
     * @param offset offset to start reading from.
     * @param length number of bytes to read from the log.
     * @return string result Bytes of log
     */
    public boolean readProcessStdoutLog(String name, int offset, int length) {
        return true;
    }

    /**
     * Read length bytes from name’s stderr log starting at offset
     *
     * @param name   the name of the process (or ‘group:name’)
     * @param offset offset to start reading from.
     * @param length number of bytes to read from the log.
     * @return string result Bytes of log
     */
    public boolean readProcessStderrLog(String name, int offset, int length) {
        return true;
    }

    /**
     * Provides a more efficient way to tail the (stdout) log than readProcessStdoutLog(). Use
     * readProcessStdoutLog() to read chunks and tailProcessStdoutLog() to tail.
     *
     * Requests (length) bytes from the (name)’s log, starting at (offset). If the total log size is
     * greater than (offset + length), the overflow flag is set and the (offset) is automatically
     * increased to position the buffer at the end of the log. If less than (length) bytes are
     * available, the maximum number of available bytes will be returned. (offset) returned is
     * always the last offset in the log +1.
     *
     * @param name   the name of the process (or ‘group:name’)
     * @param offset offset to start reading from
     * @param length maximum number of bytes to return
     * @return array result [string bytes, int offset, bool overflow]
     */
    public boolean tailProcessStdoutLog(String name, int offset, int length) {
        return true;
    }

    /**
     * Provides a more efficient way to tail the (stderr) log than readProcessStderrLog(). Use
     * readProcessStderrLog() to read chunks and tailProcessStderrLog() to tail.
     *
     * Requests (length) bytes from the (name)’s log, starting at (offset). If the total log size is
     * greater than (offset + length), the overflow flag is set and the (offset) is automatically
     * increased to position the buffer at the end of the log. If less than (length) bytes are
     * available, the maximum number of available bytes will be returned. (offset) returned is
     * always the last offset in the log +1.
     *
     * @param name   the name of the process (or ‘group:name’)
     * @param offset offset to start reading from
     * @param length maximum number of bytes to return
     * @return array result [string bytes, int offset, bool overflow]
     */
    public boolean tailProcessStderrLog(String name, int offset, int length) {
        return true;
    }

    /**
     * Clear the stdout and stderr logs for the named process and reopen them.
     *
     * @param name The name of the process (or ‘group:name’)
     * @return result Always True unless error
     */
    public boolean clearProcessLogs(String name) {
        return true;
    }

    /**
     * Clear all process log files
     */
    public boolean clearAllProcessLogs() {
        return true;
    }


}
