package com.karat.cn.blog_backstage.dao;

import com.karat.cn.blog_backstage.bean.Blog;

import java.util.List;

public interface BlogDao {

    //添加博客
    void addBlog(Blog blog);
    //根据ID查看博客
    Blog selectById(String id);
    //查看所有博客
    List<Blog> selectAll();
    //修改博客
    void updateBlog(Blog blog);
    //删除博客
    Boolean delBlog(String id);
    //分页查询博客列表
    List<Blog> selectAllByPage(int limit,int page);

}
