package com.karat.cn.blog_backstage.bean;

import java.io.Serializable;

/**
 * 友链
 */
public class Friend implements Serializable {

    //ID
    private String id;
    //友链博客名称
    private String name;
    //友链地址
    private String adrr;


    public Friend() {
    }

    public Friend(String id, String name, String adrr) {
        this.id = id;
        this.name = name;
        this.adrr = adrr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdrr() {
        return adrr;
    }

    public void setAdrr(String adrr) {
        this.adrr = adrr;
    }


    @Override
    public String toString() {
        return "friend{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", adrr='" + adrr + '\'' +
                '}';
    }
}
