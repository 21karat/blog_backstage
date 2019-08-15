package com.karat.cn.blog_backstage.vo;

import com.karat.cn.blog_backstage.bean.Comment;

import java.util.List;

/**
 * 评论Vo
 */
public class CommentResponseVo {

    //状态码
    private String state;
    //状态描述
    private String msg;
    //评论数量
    private int num;
    //评论集合
    private List<Comment> comments;

    public CommentResponseVo() {
    }

    public CommentResponseVo(String state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public CommentResponseVo(String state, String msg, int num, List<Comment> comments) {
        this.state = state;
        this.msg = msg;
        this.num = num;
        this.comments = comments;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
