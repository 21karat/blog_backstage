package com.karat.cn.blog_backstage.bean;

import java.io.Serializable;

/**
 * 用户表
 */
public class User implements Serializable {
    //用户ID
    private String id;
    //微信ID
    private String openId;
    //用户头像
    private String url;
    //用户名称
    private String name;

    public User() {
    }

    public User(String id, String openId, String url, String name) {
        this.id = id;
        this.openId = openId;
        this.url = url;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", openId='" + openId + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
