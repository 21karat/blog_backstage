package com.karat.cn.blog_backstage.vo.shiro;

import com.karat.cn.blog_backstage.bean.pojo.ShiroRole;

import java.util.List;

public class ShiroRoleVo {

    private int code;

    private String msg;

    private List<ShiroRole> shiroRoles;

    public ShiroRoleVo() {
    }

    public ShiroRoleVo(int code, String msg, List<ShiroRole> shiroRoles) {
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

    public List<ShiroRole> getShiroRoles() {
        return shiroRoles;
    }

    public void setShiroRoles(List<ShiroRole> shiroRoles) {
        this.shiroRoles = shiroRoles;
    }
}
