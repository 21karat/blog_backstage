package com.karat.cn.blog_backstage.service;

import com.karat.cn.blog_backstage.bean.pojo.User_role;

import java.util.List;

public interface UserRoleService {

    //查看用户角色
    List<User_role> select(int userid);
}
