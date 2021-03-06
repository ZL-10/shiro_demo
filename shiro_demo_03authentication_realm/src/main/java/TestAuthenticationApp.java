import com.zl.realm.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestAuthenticationApp {
    // 日志输出工具
    private static final transient Logger log = LoggerFactory.getLogger(TestAuthenticationApp.class);

    public static void main(String[] args) {

        String username = "zhangsan";
        String password = "123";

        log.info("My First Apache Shiro Application----------info");

        // 1，创建安全管理器的工厂对象 org.apache.shiro.mgt.SecurityManager;  不能使用java.lang.SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // 2,使用工厂创建安全管理器
        DefaultSecurityManager securityManager = (DefaultSecurityManager)factory.getInstance();

//        UserRealm userRealm = new UserRealm();
//
//        securityManager.setRealm(userRealm);

        // 3,把当前的安全管理器绑定当到线的线程
        SecurityUtils.setSecurityManager(securityManager);
        // 4,使用SecurityUtils.getSubject得到主体对象
        Subject subject = SecurityUtils.getSubject();
        // 5，封装用户名和密码
        AuthenticationToken token = new UsernamePasswordToken(username, password);

        // 6,得到认证
        try {
            subject.login(token);
            System.out.println("认证成功");
            System.out.println(subject.getPrincipal());
        } catch (IncorrectCredentialsException e) {
            System.out.println("用户名或密码不正确");
        }catch(UnknownAccountException e){
            System.out.println("用户名不存在");
        }

    }
}