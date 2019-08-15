package com.karat.cn.blog_backstage.vo;

import com.karat.cn.blog_backstage.bean.User;

public class UserResponseVo {

    //状态码
    private String state;
    //状态描述
    private String msg;
    //用户信息
    private User user;


    public UserResponseVo() {
    }

    public UserResponseVo(String state, String msg, User user) {
        this.state = state;
        this.msg = msg;
        this.user = user;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
