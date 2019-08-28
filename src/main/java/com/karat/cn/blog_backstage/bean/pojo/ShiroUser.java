package com.karat.cn.blog_backstage.bean.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 后台权限用户
 */
@Entity
@Table(name="sys_users")
public class ShiroUser {

    //自增ID
    @Id
    int id;
    //用户名
    @Column(name="username")
    String username;
    //用户密码
    @Column(name="password")
    String password;
    //是否锁住(0：锁住 1：没锁住)
    @Column(name="locked")
    int locked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ShiroUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", locked=" + locked +
                '}';
    }
}
