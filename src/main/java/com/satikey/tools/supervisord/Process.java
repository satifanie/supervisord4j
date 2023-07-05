package com.satikey.tools.supervisord;

import java.io.Serializable;

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
 * @author Lei Duan(satifanie@gmail.com) .
 * see http://supervisord.org/api.html#supervisor.rpcinterface.SupervisorNamespaceRPCInterface.getProcessInfo
 */
public class Process implements Serializable {
    private static final long serialVersionUID = -3585545987673007624L;
    private String name;
    private String group;
    private String description;
    private String start;
    private String stop;
    private String now;
    private String status;
    private String stateName;
    private String spawnerr;
    private int exitStatus;
    private String logFile;
    private String stdoutFile;
    private String stderrFile;
    private int pid;

    public Process(String processName) {
        this.name = processName;
    }

    public Process(String processName, String groupName) {
        this(processName);
        this.group = groupName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getSpawnerr() {
        return spawnerr;
    }

    public void setSpawnerr(String spawnerr) {
        this.spawnerr = spawnerr;
    }

    public int getExitStatus() {
        return exitStatus;
    }

    public void setExitStatus(int exitStatus) {
        this.exitStatus = exitStatus;
    }

    public String getLogFile() {
        return logFile;
    }

    public void setLogFile(String logFile) {
        this.logFile = logFile;
    }

    public String getStdoutFile() {
        return stdoutFile;
    }

    public void setStdoutFile(String stdoutFile) {
        this.stdoutFile = stdoutFile;
    }

    public String getStderrFile() {
        return stderrFile;
    }

    public void setStderrFile(String stderrFile) {
        this.stderrFile = stderrFile;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
