package com.karat.cn.blog_backstage.bean;

import java.io.Serializable;

/**
 * 博客
 */
public class Blog implements Serializable {
    //博客ID
    private String id;
    //作者
    private String author;
    //标题
    private String title;
    //展示图
    private String url;
    //内容
    private String content;
    //时间
    private String time;
    //喜欢人数
    private int love;
    //阅读人数
    private int read;
    //观看人数
    private int watch;

    public Blog() {
    }

    public Blog(String id, String author, String title, String url, String content, String time, int love, int read, int watch) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.url = url;
        this.content = content;
        this.time = time;
        this.love = love;
        this.read = read;
        this.watch = watch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public int getWatch() {
        return watch;
    }

    public void setWatch(int watch) {
        this.watch = watch;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", love=" + love +
                ", read=" + read +
                ", watch=" + watch +
                '}';
    }
}
