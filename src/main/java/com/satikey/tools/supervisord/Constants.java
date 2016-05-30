package com.satikey.tools.supervisord;

/**
 * @author Lei Duan(satifanie@gmail.com) .
 */
public interface Constants {
    int FATAL = 1;
    int RUNNING = 2;
    int RESTARTING = 0;
    int SHUTDOWN = -1;

    String SYSTEM_LIST_METHODS = "system.listMethods";
    String SYSTEM_METHOD_HELP = "system.methodHelp";
    String SYSTEM_METHOD_SIGNATURE = "system.methodSignature";
    String SYSTEM_MULTI_CALL = "system.multicall";

    //PROCESS
    String SYSTEM_GETAPIVERSION = "supervisor.getAPIVersion";
    String SYSTEM_GETSUPERVISORVERSION = "supervisor.getSupervisorVersion";
}
