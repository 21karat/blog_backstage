package com.karat.cn.blog_backstage.vo.shiro;

import com.karat.cn.blog_backstage.bean.pojo.ShiroRole;

import java.util.List;

public class ShiroRoleVo {

    private int code;

    private String msg;

    private List<RoleVo> shiroRoles;

    public ShiroRoleVo() {
    }

    public ShiroRoleVo(int code, String msg, List<RoleVo> shiroRoles) {
        this.code = code;
        this.msg = msg;
        this.shiroRoles = shiroRoles;
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

    public List<RoleVo> getShiroRoles() {
        return shiroRoles;
    }

    public void setShiroRoles(List<RoleVo> shiroRoles) {
        this.shiroRoles = shiroRoles;
    }
}
