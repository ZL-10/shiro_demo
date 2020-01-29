package com.zl.realm;

import com.zl.domain.User;
import com.zl.service.UserService;
import com.zl.service.impl.UserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;

public class UserRealm extends AuthenticatingRealm {

    private UserService userService=new UserServiceImpl();

    /**
     * 做认证
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取身份
        String username=token.getPrincipal().toString();
        System.out.println(username);

        //获取凭证
        token.getCredentials();

        User user=userService.queryUserByUSerName(username);
        if(null!=user){
            /**
             * 参数1 可以传任意对象
             * 参数2 从数据库例名查询出来的密码
             * 参数3 当前类名
             * */
            SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user,user.getPwd(),this.getName());
            return info;
        }else{
            return null;
        }


    }
}
