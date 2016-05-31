import com.satikey.tools.supervisord.Supervisord;

/**
 * @author duanl<890117@dms.yudean.com>
 */
public class SupervisordTest { public static void main(String[] args) {
    Supervisord.connect("http://120.25.121.0:9001/RPC2")
            .auth("username", "password")
            .listMethods();

}
}
