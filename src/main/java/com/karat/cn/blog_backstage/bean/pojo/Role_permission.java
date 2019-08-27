package com.karat.cn.blog_backstage.bean.pojo;

/**
 * 角色权限绑定表
 */
public class Role_permission {

    //自增ID
    int id;
    //角色（角色ID）
    int roleId;
    //权限(权限ID)
    int permissionId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }
}
