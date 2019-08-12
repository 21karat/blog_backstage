package com.karat.cn.blog_backstage.bean;

/**
 * 评论
 */
public class Comment {
    //评论ID
    private String id;
    //评论人头像
    private String url;
    //评论人名称
    private String username;
    //评论内容
    private String content;
    //评论时间
    private String time;
    //博客ID
    private String blogId;

    public Comment() {
    }

    public Comment(String id, String url, String username, String content, String time, String blogId) {
        this.id = id;
        this.url = url;
        this.username = username;
        this.content = content;
        this.time = time;
        this.blogId = blogId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }
}
