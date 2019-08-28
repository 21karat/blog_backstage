package com.karat.cn.blog_backstage.service.impl;

import com.karat.cn.blog_backstage.bean.pojo.User_role;
import com.karat.cn.blog_backstage.service.UserRoleService;
import com.karat.cn.blog_backstage.service.reposition.UserRoleReposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleReposition userRoleReposition;

    //查看用户角色
    public List<User_role> select(int userid){
        return userRoleReposition.findAllByUserId(userid);
    }

}
