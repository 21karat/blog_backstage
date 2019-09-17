package com.karat.cn.blog_backstage.vo.view;

import com.karat.cn.blog_backstage.bean.Author;

public class RequestAuthorVo {

    private int state;

    private String msg;

    private Author author;

    public RequestAuthorVo() {
    }

    public RequestAuthorVo(int state, String msg, Author author) {
        this.state = state;
        this.msg = msg;
        this.author = author;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
