package com.karat.cn.blog_backstage.bean.pojo;

/**
 * 后台权限角色
 */
public class ShiroRole {

    //角色id
    int roleid;
    //角色名
    String role;
    //描述
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
