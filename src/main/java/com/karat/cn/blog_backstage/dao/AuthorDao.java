package com.karat.cn.blog_backstage.dao;

import com.karat.cn.blog_backstage.bean.Author;


public interface AuthorDao {

    //添加联系作者
    void add(Author author);
    //查看联系作者
    Author select();

}
