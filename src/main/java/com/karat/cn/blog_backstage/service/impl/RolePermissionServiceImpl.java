package com.karat.cn.blog_backstage.service.impl;

import com.karat.cn.blog_backstage.bean.pojo.Role_permission;
import com.karat.cn.blog_backstage.service.RolePermissionService;
import com.karat.cn.blog_backstage.service.reposition.RolePermissionReposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    RolePermissionReposition rolePermissionReposition;

    //查看用户权限
    public List<Role_permission> select(int roleId){
        return rolePermissionReposition.findAllByRoleId(roleId);
    }
}
