package com.karat.cn.blog_backstage.bean.pojo;

/**
 * 后台权限用户
 */
public class ShiroUser {

    //自增ID
    int userid;
    //用户名
    String username;
    //用户密码
    String password;
    //是否锁住(0：锁住 1：没锁住)
    int locked;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }
}
