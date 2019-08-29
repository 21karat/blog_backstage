package com.karat.cn.blog_backstage.config;


import com.karat.cn.blog_backstage.bean.pojo.ShiroUser;
import com.karat.cn.blog_backstage.service.ShiroUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Set;
import org.apache.log4j.Logger;

public class Realm extends AuthorizingRealm {

    private Logger logger=Logger.getLogger(Realm.class);

    @Autowired
    private ShiroUserService shiroUserService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("---------------------------->授权:");
        //从凭证中获得用户名
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        //根据用户名查询用户对象
        //ShiroUser user = shiroUserService.findByUsername(username);
        //查询用户拥有的角色
        Set<String> list = shiroUserService.findRoles(username);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        list.forEach(i->{
            info.addStringPermission(i);
        });
        return info;
    }

    /**
     * 提供帐户信息，返回认证信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("---------------------------->登陆验证:");
        String userName=(String)authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());

        ShiroUser user = shiroUserService.findByUsername(userName);
        if(user==null) {
            //用户不存在就抛出异常
            throw new UnknownAccountException();
        }
        if(user.getLocked()==0) {
            //用户被锁定就抛异常
            throw new LockedAccountException();
        }
        //密码可以通过SimpleHash加密，然后保存进数据库。
        //此处是获取数据库内的账号、密码、盐值，保存到登陆信息info中
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,password,getName());

        return info;
    }

}
