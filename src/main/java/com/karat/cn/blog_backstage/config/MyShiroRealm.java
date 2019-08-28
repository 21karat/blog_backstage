package com.karat.cn.blog_backstage.config;

import com.karat.cn.blog_backstage.bean.pojo.ShiroUser;
import com.karat.cn.blog_backstage.service.ShiroUserService;
import org.apache.shiro.realm.AuthorizingRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;

/*
*
 * shiro核心配置
*/


public class MyShiroRealm extends AuthorizingRealm {


    @Autowired
    private ShiroUserService userService;

    //权限信息，包括角色以及权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        String username = (String)principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.findRoles(username));
        authorizationInfo.setStringPermissions(userService.findPermissions(username));
        return authorizationInfo;
    }

/*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("shiro登录验证");
        //从令牌中取值
        String username = (String)token.getPrincipal();
        //根据用户名查看用户信息
        ShiroUser user = userService.findByUsername(username);
        //非空账号状态判断
        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        if(Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }
        //将取到的用户名密码对比token中的入参
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(),//用户名
                user.getPassword(),
                getName()  //realm name
        );
        return authenticationInfo;
    }

}
