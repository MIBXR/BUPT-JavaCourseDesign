import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import com.jcraft.jsch.Channel;

/**
 * @author xierui2022140771
 * @description Java网络编程练习：使用SSH连接实验室服务器
 *              参考1：http://www.jcraft.com/jsch/
 *              参考2：https://www.cnblogs.com/goloving/p/15023195.html
 */

public class WorkFive {
    private static final String USER="xx"; // 隐私起见，在测试后隐藏了实验室服务器的实际信息
    private static final String PASSWORD="xxxxxx"; // 隐私起见，在测试后隐藏了实验室服务器的实际信息
    private static final String HOST="0.0.0.0"; // 隐私起见，在测试后隐藏了实验室服务器的实际信息
    private static final int DEFAULT_SSH_PORT=22; // 隐私起见，在测试后隐藏了实验室服务器的实际信息

    public static void main(String[] arg){

        try{
            JSch jsch=new JSch();
            Session session = jsch.getSession(USER,HOST,DEFAULT_SSH_PORT);
            session.setPassword(PASSWORD);

            UserInfo userInfo = new UserInfo() {
                @Override
                public String getPassphrase() {
                    System.out.println("getPassphrase");
                    return null;
                }
                @Override
                public String getPassword() {
                    System.out.println("getPassword");
                    return null;
                }
                @Override
                public boolean promptPassword(String s) {
                    System.out.println("promptPassword:"+s);
                    return false;
                }
                @Override
                public boolean promptPassphrase(String s) {
                    System.out.println("promptPassphrase:"+s);
                    return false;
                }
                @Override
                public boolean promptYesNo(String s) {
                    System.out.println("promptYesNo:"+s);
                    return true;
                }
                @Override
                public void showMessage(String s) {
                    System.out.println("showMessage:"+s);
                }
            };

            session.setUserInfo(userInfo);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect(30000);

            Channel channel=session.openChannel("shell");
            channel.setInputStream(System.in);
            channel.setOutputStream(System.out);
            channel.connect(3000);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}