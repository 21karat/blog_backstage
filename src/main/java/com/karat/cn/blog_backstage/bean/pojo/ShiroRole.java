package com.karat.cn.blog_backstage.bean.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 后台权限角色
 */
@Entity
@Table(name="sys_roles")
public class ShiroRole {

    //角色id
    @Id
    int roleid;
    //角色名
    @Column(name="role")
    String role;
    //描述
    @Column(name="description")
    String description;

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
