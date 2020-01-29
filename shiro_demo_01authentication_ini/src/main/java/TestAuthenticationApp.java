import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
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
        log.debug("My First Apache Shiro Application----------debug");
        log.warn("My First Apache Shiro Application----------warn");
        log.error("My First Apache Shiro Application----------error");
        // 1，创建安全管理器的工厂对象 org.apache.shiro.mgt.SecurityManager;  不能使用java.lang.SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // 2,使用工厂创建安全管理器
        SecurityManager securityManager = factory.getInstance();
        // 3,把当前的安全管理器绑定当到线的线程
        SecurityUtils.setSecurityManager(securityManager);
        // 4,使用SecurityUtils.getSubject得到主体对象
        Subject subject = SecurityUtils.getSubject();
        // 5，封装用户名和密码
        AuthenticationToken token = new UsernamePasswordToken(username, password);
        // 6,得到认证
        try {
            subject.login(token);
            System.out.println("认证通过");
        } catch (AuthenticationException e) {
            System.out.println("用户名或密码不正确");
        }
		/*} catch (IncorrectCredentialsException e) {
			System.out.println("密码不正确");
		} catch (UnknownAccountException e) {
			System.out.println("用户名不存在");
		}*/

        Subject subject2 = SecurityUtils.getSubject();

        System.out.println(subject);
        System.out.println(subject2);

        aaaa();

    }

    public static void aaaa() {
        Subject subject2 = SecurityUtils.getSubject();
        System.out.println(subject2);
    }

}