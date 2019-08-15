package com.karat.cn.blog_backstage.dao;

import java.util.List;

public interface TagDao {

    //查标签下的博客ID集合
    List<String> selectByTag(String type);

    //添加标签对应的博客
    void addTag(String blogId,String type);

}
