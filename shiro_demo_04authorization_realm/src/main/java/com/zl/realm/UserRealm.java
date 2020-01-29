package com.zl.realm;

import com.zl.domain.ActiveUser;
import com.zl.domain.User;
import com.zl.service.PermissionService;
import com.zl.service.RoleService;
import com.zl.service.UserService;
import com.zl.service.impl.PermissionServiceImpl;
import com.zl.service.impl.RoleServiceImpl;
import com.zl.service.impl.UserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

    private UserService userService=new UserServiceImpl();
    private RoleService roleService=new RoleServiceImpl();
    private PermissionService permissionService=new PermissionServiceImpl();

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
            ActiveUser activeUser=null;
            List<String> roles=roleService.queryUserByName(user.getUserName());

            List<String> permissions=permissionService.queryPermissionByUserName(user.getUserName());

            activeUser=new ActiveUser(user,roles,permissions);

            /**
             * 参数1 可以传任意对象
             * 参数2 从数据库例名查询出来的密码
             * 参数3 当前类名
             * */
            SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(activeUser,user.getPwd(),this.getName());
            return info;
        }else{
            return null;
        }


    }


    /**
     * 做授权
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ActiveUser user=(ActiveUser) principals.getPrimaryPrincipal();
        System.out.println("doGetAuthorizationInfo");
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

        if(null!=user.getRoles()){
            info.addRoles(user.getRoles());
        }


        if(null!=user.getPermissions()){
            info.addStringPermissions(user.getPermissions());
        }


        return info;
    }
}
