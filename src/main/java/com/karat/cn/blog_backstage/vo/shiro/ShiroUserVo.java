package com.karat.cn.blog_backstage.vo.shiro;

import com.karat.cn.blog_backstage.bean.pojo.ShiroUser;

import java.util.List;

public class ShiroUserVo {

    private int code;

    private String msg;

    private List<ShiroUser> shiroUsers;


    public ShiroUserVo() {
    }

    public ShiroUserVo(int code, String msg, List<ShiroUser> shiroUsers) {
        this.code = code;
        this.msg = msg;
        this.shiroUsers = shiroUsers;
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

    public List<ShiroUser> getShiroUsers() {
        return shiroUsers;
    }

    public void setShiroUsers(List<ShiroUser> shiroUsers) {
        this.shiroUsers = shiroUsers;
    }
}
