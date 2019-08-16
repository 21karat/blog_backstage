package com.karat.cn.blog_backstage.vo;

import java.io.Serializable;

/**
 * 入参
 */
public class UserRequestVo implements Serializable {
    //微信code
    private String code;
    //微信名称
    private String nickName;
    //微信头像
    private String avatarUrl;


    public UserRequestVo() {
    }

    public UserRequestVo(String code, String nickName, String avatarUrl) {
        this.code = code;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "UserRequestVo{" +
                "code='" + code + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}

