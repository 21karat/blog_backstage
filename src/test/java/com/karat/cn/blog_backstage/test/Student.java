package com.karat.cn.blog_backstage.test;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    //编号
    private Integer id;

    //姓名
    private String name;

    //性别
    private String sex;

    public Student() {
    }

    public Student(Integer id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
