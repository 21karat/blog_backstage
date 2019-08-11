package com.karat.cn.blog_backstage.vo;

import com.karat.cn.blog_backstage.bean.Blog;

/**
 * 博客详情vo
 */
public class DetailResponseVo {
    //请求状态码
    private String code;
    //请求状态信息
    private String msg;
    //Html页面转字符串
    private String slug;
    //博客详情数据
    private Blog blog;


    public DetailResponseVo() {
    }

    public DetailResponseVo(String code, String msg, String slug, Blog blog) {
        this.code = code;
        this.msg = msg;
        this.slug = slug;
        this.blog = blog;
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
