package com.karat.cn.blog_backstage.bean;

/**
 * 用户表
 */
public class User {
    //用户ID
    private String id;
    //用户头像
    private String url;
    //用户名称
    private String name;

    public User() {
    }

    public User(String id, String url, String name) {
        this.id = id;
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
}
