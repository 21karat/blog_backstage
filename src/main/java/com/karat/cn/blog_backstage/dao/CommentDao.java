package com.karat.cn.blog_backstage.dao;

import com.karat.cn.blog_backstage.bean.Comment;

import java.util.List;

public interface CommentDao {

    //添加评论
    void addComment(Comment comment);
    //评论集合
    List<Comment> selectById(String blogId);

}
