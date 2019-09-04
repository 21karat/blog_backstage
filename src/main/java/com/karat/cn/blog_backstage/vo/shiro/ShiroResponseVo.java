package com.karat.cn.blog_backstage.vo.shiro;

import com.karat.cn.blog_backstage.bean.pojo.Permission;
import com.karat.cn.blog_backstage.bean.pojo.ShiroUser;

import java.util.List;

public class ShiroResponseVo {
    //请求码
    private int code;
    //请求描述
    private String msg;
    //权限
    private List<Permission> permissions;
    //角色
    private List<RoleVo> shiroRoles;
    //用户
    private List<ShiroUser> shiroUsers;

    public ShiroResponseVo() {
    }

    public ShiroResponseVo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<RoleVo> getShiroRoles() {
        return shiroRoles;
    }

    public void setShiroRoles(List<RoleVo> shiroRoles) {
        this.shiroRoles = shiroRoles;
    }

    public List<ShiroUser> getShiroUsers() {
        return shiroUsers;
    }

    public void setShiroUsers(List<ShiroUser> shiroUsers) {
        this.shiroUsers = shiroUsers;
    }
}
