* Supervisord4j *
=====================

 This is a simple java client for Supervisor’s XML-RPC API.
 There are many third-party client which you can find by visiting: [Third Party Applications and Libraries](http://supervisord.org/plugins.html)
 But no java was found. 
 the client was simple enough, it is depend on no other jars. So you can import into you project easily.
 ----------


# API
the following method has been implemented and tested.
### supervisord system related
* getSupervisorVersion
* getIdentification
* getState
* getPID
* readLog
* clearLog
* shutdown
* restart
* listMethods
* methodHelp
* methodSignature(not tested)
* <del>multicall</del>

### process related
* getProcessInfo
* getAllProcessInfo
* startAllProcesses
* startProcessGroup (not tested)
* stopProcess
* stopProcessGroup(not tested)
* stopAllProcesses
* signalProcess(not tested)
* signalProcessGroup(not tested)
* signalAllProcesses(not tested)
* sendProcessStdin(not tested)
* sendRemoteCommEvent(not tested)
* <del>reloadConfig</del> (not impl)
* <del>addProcessGroup</del>
* <del>removeProcessGroup</del>
* <del>readProcessStdoutLog</del>
* <del>readProcessStderrLog</del>
* <del>tailProcessStdoutLog</del>
* <del>tailProcessStderrLog</del>
* <del>clearProcessLogs</del>
* <del>clearAllProcessLogs</del>

the method should be enough for common use, if u want  more . u can pull requests.

----------
#Usage
- Enable/Uncomment inet_http_server (found in supervisord.conf) for all your supervisord servers.

```
[inet_http_server]
port=*:9001
username="yourusername"
password="yourpass"
```

> If not visited by the same server , maybe you should config the iptables

- The Java Sample Code

```
   Supervisord supervisord = Supervisord
       //API ADDR,Default:http://localhost:9001/RPC2
                .connect(api)  
          // USERNAME AND PASSWORD       
                .auth(userName, password)
          // the Identification, U shoud find it in "supervisord.conf" default supervisor
                .namespace("supervisor")
                .proxy("HOST","PORT") //IF NEED
         ;
```
Happy supervisord.

#Thanks to
----------
-[gturri](https://github.com/gturri/aXMLRPC) - the XML RPC call was based on his job.
-[Android Open Source Project](https://developer.android.com/reference/android/util/Base64.html) - the base64 tools was import from his.