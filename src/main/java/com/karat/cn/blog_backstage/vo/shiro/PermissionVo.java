package com.karat.cn.blog_backstage.vo.shiro;

import com.karat.cn.blog_backstage.bean.pojo.Permission;

import java.util.List;

public class PermissionVo {

    private int code;

    private String msg;

    private List<Permission> permissions;

    public PermissionVo() {
    }

    public PermissionVo(int code, String msg, List<Permission> permissions) {
        this.code = code;
        this.msg = msg;
        this.permissions = permissions;
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
}
