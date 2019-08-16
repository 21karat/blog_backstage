package com.karat.cn.blog_backstage.dao;

import com.karat.cn.blog_backstage.bean.Friend;

import java.util.List;

public interface FriendDao {

    //查看所有友链
    List<Friend> selectAll();
    //添加友链
    void add(Friend friend);

}
