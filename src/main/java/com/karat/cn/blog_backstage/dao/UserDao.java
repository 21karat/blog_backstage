package com.karat.cn.blog_backstage.dao;

import com.karat.cn.blog_backstage.bean.User;

public interface UserDao {

    //添加用户信息
    void addUser(User user);
    //根据用户openId查看用户信息
    User selectById(String openId);

}
