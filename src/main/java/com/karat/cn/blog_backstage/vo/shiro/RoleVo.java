package com.karat.cn.blog_backstage.vo.shiro;

public class RoleVo {

    int roleid;
    //角色名
    String role;
    //描述
    String description;
    //拥有权限描述
    String roledes;

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

    public String getRoledes() {
        return roledes;
    }

    public void setRoledes(String roledes) {
        this.roledes = roledes;
    }
}
