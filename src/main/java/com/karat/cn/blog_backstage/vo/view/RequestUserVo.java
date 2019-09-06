package com.karat.cn.blog_backstage.vo.view;


public class RequestUserVo {

    public String openId;
    public String url;
    public String name;

    public RequestUserVo() {
    }

    public RequestUserVo(String openId, String url, String name) {
        this.openId = openId;
        this.url = url;
        this.name = name;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
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

    @Override
    public String toString() {
        return "RequestUserVo{" +
                "openId='" + openId + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
