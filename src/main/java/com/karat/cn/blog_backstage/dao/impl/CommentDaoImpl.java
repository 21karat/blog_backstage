package com.karat.cn.blog_backstage.dao.impl;

import com.karat.cn.blog_backstage.bean.Comment;
import com.karat.cn.blog_backstage.dao.CommentDao;
import com.karat.cn.blog_backstage.util.RedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentDaoImpl implements CommentDao {

    @Autowired
    RedisTemplate redisTemplate;

    //添加评论
    public void addComment(Comment comment){
        if (!redisTemplate.hasKey(RedisKey.COMMENT+comment.getId())) {
            //添加评论
            redisTemplate.opsForValue().set(RedisKey.COMMENT+comment.getId(),comment);
            //添加评论ID到List列表
            redisTemplate.opsForList().leftPush(RedisKey.COMMENTLIST+comment.getBlogId(),comment.getId());
        }
    }
    //评论集合
    public List<Comment> selectById(String blogId){
        List<Comment> comments=new ArrayList<>();
        //获取List列表所有评论ID
        List<String> list =  redisTemplate.opsForList().range(RedisKey.COMMENTLIST+blogId,0,-1);
        list.forEach(i->{
            comments.add((Comment)redisTemplate.opsForValue().get(RedisKey.COMMENT+i));
        });
        return comments;
    }
}
