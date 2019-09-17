package com.karat.cn.blog_backstage.dao.impl;

import com.karat.cn.blog_backstage.bean.Author;
import com.karat.cn.blog_backstage.dao.AuthorDao;
import com.karat.cn.blog_backstage.util.RedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class AuthorDaoImpl implements AuthorDao {

    @Autowired
    RedisTemplate redisTemplate;

    //添加或修改联系作者
    public void insertOrUpdate(Author author){
        redisTemplate.opsForValue().set(RedisKey.AUTHOR,author);
    }
    //查看联系作者
    public Author select(){
        return (Author) redisTemplate.opsForValue().get(RedisKey.AUTHOR);
    }

}
