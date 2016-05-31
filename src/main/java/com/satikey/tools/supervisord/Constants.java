package com.satikey.tools.supervisord;

/**
 * @author Lei Duan(satifanie@gmail.com) .
 */
public interface Constants {
    int FATAL = 1;
    int RUNNING = 2;
    int RESTARTING = 0;
    int SHUTDOWN = -1;
    //API METHOD DEFINE:
//    supervisor.addProcessGroup
//    supervisor.clearAllProcessLogs
//    supervisor.clearProcessLog
//    supervisor.clearProcessLogs
//    supervisor.getAllConfigInfo
//    supervisor.getIdentification
//    supervisor.getSupervisorVersion
//    supervisor.readMainLog
//    supervisor.readProcessLog
//    supervisor.readProcessStderrLog
//    supervisor.readProcessStdoutLog
//    supervisor.reloadConfig
//    supervisor.removeProcessGroup
//    supervisor.sendProcessStdin
//    supervisor.sendRemoteCommEvent
//    supervisor.tailProcessLog
//    supervisor.tailProcessStderrLog
//    supervisor.tailProcessStdoutLog
//    system.listMethods
//    system.methodHelp
//    system.methodSignature
//    system.multicall
    String SYSTEM_LIST_METHODS = "system.listMethods";
    String SYSTEM_METHOD_HELP = "system.methodHelp";
    String SYSTEM_METHOD_SIGNATURE = "system.methodSignature";
    String SYSTEM_MULTI_CALL = "system.multicall";

    //PROCESS
    String _GET_PID = "getPID";
    String _GET_API_VERSION = "getAPIVersion";
    String _GET_SUPERVISOR_VERSION = "getSupervisorVersion";
    String _GET_IDENTIFICATION = "getIdentification";
    String _GET_STATE = "getState";
    String _READ_LOG = "readLog";
    String _CLEAR_LOG = "clearLog";
    String _SHUTDOWN = "shutdown";
    String _RESTART = "restart";
    String _GET_PROCESS_INFO = "getProcessInfo";
    String _GET_ALL_PROCESS_INFO = "getAllProcessInfo";
    String _START_PROCESS = "startProcess";
    String _START_ALL_PROCESSES = "startAllProcesses";
    String _START_PROCESSES_GROUP = "startProcessGroup";
    String _STOP_PROCESS = "stopProcess";
    String _STOP_PROCESSES_GROUP = "stopProcessGroup";
    String _STOP_ALL_PROCESSES = "stopAllProcesses";
    String _SIGNAL_PROCESS = "signalProcess";
    String _SIGNAL_PROCESSES_GROUP = "signalProcessGroup";
    String _SIGNAL_ALL_PROCESSES = "signalAllProcesses";

}
