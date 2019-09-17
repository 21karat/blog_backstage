package com.karat.cn.blog_backstage.vo.view;

import com.karat.cn.blog_backstage.bean.Friend;

public class RequestFrendVo {

    private int code;

    private String msg;

    private Friend friend;

    public RequestFrendVo() {
    }

    public RequestFrendVo(int code, String msg, Friend friend) {
        this.code = code;
        this.msg = msg;
        this.friend = friend;
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

    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }
}
