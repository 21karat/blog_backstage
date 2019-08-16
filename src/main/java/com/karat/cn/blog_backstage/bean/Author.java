package com.karat.cn.blog_backstage.bean;

import java.io.Serializable;

/**
 * 联系作者
 */
public class Author implements Serializable {

    //标题内容
    private String title;
    //邮箱地址
    private String mailbox;
    //公众号名称
    private String publicNumber;
    //git地址
    private String gitHub;
    //博客园地址
    private String blogGarden;


    public Author() {
    }

    public Author(String title, String mailbox, String publicNumber, String gitHub, String blogGarden) {
        this.title = title;
        this.mailbox = mailbox;
        this.publicNumber = publicNumber;
        this.gitHub = gitHub;
        this.blogGarden = blogGarden;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getPublicNumber() {
        return publicNumber;
    }

    public void setPublicNumber(String publicNumber) {
        this.publicNumber = publicNumber;
    }

    public String getGitHub() {
        return gitHub;
    }

    public void setGitHub(String gitHub) {
        this.gitHub = gitHub;
    }

    public String getBlogGarden() {
        return blogGarden;
    }

    public void setBlogGarden(String blogGarden) {
        this.blogGarden = blogGarden;
    }

    @Override
    public String toString() {
        return "Author{" +
                "title='" + title + '\'' +
                ", mailbox='" + mailbox + '\'' +
                ", publicNumber='" + publicNumber + '\'' +
                ", gitHub='" + gitHub + '\'' +
                ", blogGarden='" + blogGarden + '\'' +
                '}';
    }
}
