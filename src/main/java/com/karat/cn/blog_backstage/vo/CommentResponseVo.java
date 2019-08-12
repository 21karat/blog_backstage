package com.karat.cn.blog_backstage.vo;

import com.karat.cn.blog_backstage.bean.Comment;

import java.util.List;

public class CommentResponseVo {

    private int num;

    private List<Comment> comments;

    public CommentResponseVo() {
    }

    public CommentResponseVo(int num, List<Comment> comments) {
        this.num = num;
        this.comments = comments;
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
