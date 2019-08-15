package com.karat.cn.blog_backstage.dao.impl;

import com.karat.cn.blog_backstage.dao.TagDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagDaoImpl implements TagDao {

    @Autowired
    RedisTemplate redisTemplate;

    //查标签下的博客ID集合
    public List<String> selectByTag(String type){
        return redisTemplate.opsForList().range(type,0,-1);
    }

    //添加标签对应的博客
    public void addTag(String blogId,String type){
        redisTemplate.opsForList().leftPush(type,blogId);
    }
}
