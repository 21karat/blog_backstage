package com.karat.cn.blog_backstage.dao.impl;

import com.karat.cn.blog_backstage.bean.Blog;
import com.karat.cn.blog_backstage.dao.BlogDao;
import com.karat.cn.blog_backstage.util.RedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogDaoImpl implements BlogDao {

    @Autowired
    RedisTemplate redisTemplate;

    //添加博客
    public void addBlog(Blog blog){
        if (!redisTemplate.hasKey(RedisKey.BLOG+blog.getId())) {
            redisTemplate.opsForValue().set(RedisKey.BLOG+blog.getId(),blog);//添加博客
            redisTemplate.opsForList().leftPush(RedisKey.BLOGLIST,blog.getId());//添加博客ID到List列表
        }
    }
    //根据ID查看博客
    public Blog selectById(String id){
        Blog blog=null;
        //缓存存在
        if (redisTemplate.hasKey(RedisKey.BLOG+id)) {
            blog=(Blog)redisTemplate.opsForValue().get(RedisKey.BLOG+id);
        }
        return blog;
    }
    //查看所有博客
    public List<Blog> selectAll(){
        //获取List列表所有ID
        List<String> list =  redisTemplate.opsForList().range(RedisKey.BLOGLIST,0,-1);
        List<Blog> blogs=new ArrayList<>();
        list.forEach(i->{
            if (redisTemplate.hasKey(RedisKey.BLOG+i)) {
                blogs.add((Blog)redisTemplate.opsForValue().get(RedisKey.BLOG+i));
            }
        });
        return blogs;
    }
    //修改博客
    public void updateBlog(Blog blog){
        //缓存存在
        if (redisTemplate.hasKey(RedisKey.BLOG+blog.getId())) {
            redisTemplate.opsForValue().set(RedisKey.BLOG+blog.getId(),blog);//添加博客
        }
    }
    //删除博客
    public Boolean delBlog(String id){
       return redisTemplate.delete(RedisKey.BLOG+id);
    }
    //分页查询博客列表
    public List<Blog> selectAllByPage(int limit,int page){
        //获取List列表所有ID
        List<String> list =  redisTemplate.opsForList().range(RedisKey.BLOGLIST,limit,page);
        List<Blog> blogs=new ArrayList<>();
        list.forEach(i->{
            if (redisTemplate.hasKey(RedisKey.BLOG+i)) {
                blogs.add((Blog)redisTemplate.opsForValue().get(RedisKey.BLOG+i));
            }
        });
        return blogs;
    }
}
