package com.karat.cn.blog_backstage.wx;

import com.karat.cn.blog_backstage.bean.Author;
import com.karat.cn.blog_backstage.bean.User;
import com.karat.cn.blog_backstage.dao.AuthorDao;
import com.karat.cn.blog_backstage.dao.UserDao;
import com.karat.cn.blog_backstage.util.RedisKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorDemo {


    @Autowired
    AuthorDao authorDao;
    @Autowired
    UserDao userDao;
    @Autowired
    RedisTemplate redisTemplate;


    @Test
    public void selectAll(){
        System.out.println(authorDao.select());
    }

    @Test
    public void add(){
        Author author=new Author("不埋怨谁，不嘲笑谁，也不羡慕谁，阳光下灿烂，风雨中奔跑，做自己的梦，走自己的路。","lijing13949080725@163.com","21Karat","https://github.com/21karat","https://www.cnblogs.com/LJing21/");
        authorDao.add(author);
    }

    @Test
    public void select(){

        System.out.println((User)redisTemplate.opsForValue().get(RedisKey.USER+"oaXaZ5Vj1FJEMI_YPMmifOXKFTYQ"));
    }
}
