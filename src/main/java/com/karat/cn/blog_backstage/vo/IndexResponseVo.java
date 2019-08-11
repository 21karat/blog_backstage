package com.karat.cn.blog_backstage.vo;

import com.karat.cn.blog_backstage.bean.Blog;

import java.util.List;

/**
 * 博客列表返回vo
 */
public class IndexResponseVo {
    //状态码
    private String code;
    //状态描述
    private String msg;
    //当前页数
    private int page;
    //内容
    private List<Blog> blogs;


    public IndexResponseVo() {
    }

    public IndexResponseVo(String code, String msg, int page, List<Blog> blogs) {
        this.code = code;
        this.msg = msg;
        this.page = page;
        this.blogs = blogs;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
