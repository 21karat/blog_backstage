package com.karat.cn.blog_backstage.vo.shiro;

public class ShiroUserVo {

    // ID
    int id;
    //用户名
    String username;
    //用户密码
    String password;
    //是否锁住(0：锁住 1：没锁住)
    int locked;
    //角色
    String role;
    //权限
    String permission;

    public ShiroUserVo() {
    }

    public ShiroUserVo(int id, String username, String password, int locked, String role, String permission) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.locked = locked;
        this.role = role;
        this.permission = permission;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
