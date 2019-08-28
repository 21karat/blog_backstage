package com.karat.cn.blog_backstage.bean.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色权限绑定表
 */
@Entity
@Table(name="sys_roles_permissions")
public class Role_permission {

    @Id
    int id;
    //角色（角色ID）
    @Column(name="role_id")
    int roleId;
    //权限(权限ID)
    @Column(name="permission_id")
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
