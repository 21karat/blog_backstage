package com.karat.cn.blog_backstage.service;

import com.karat.cn.blog_backstage.bean.pojo.Role_permission;

import java.util.List;

public interface RolePermissionService {

    //查看用户权限
    List<Role_permission> select(int roleId);
}
