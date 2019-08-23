package com.karat.cn.blog_backstage.demo;

import com.karat.cn.blog_backstage.bean.User;
import com.karat.cn.blog_backstage.dao.UserDao;
import com.karat.cn.blog_backstage.util.RedisKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDemo {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    UserDao userDao;


    @Test
    public void add(){
        redisTemplate.opsForList().leftPush(RedisKey.USERLIST,"oaXaZ5TNQdOxTi6x6nUAgAJKcMqg");
        redisTemplate.opsForList().leftPush(RedisKey.USERLIST,"oaXaZ5Vj1FJEMI_YPMmifOXKFTYQ");
        redisTemplate.opsForList().leftPush(RedisKey.USERLIST,"oaXaZ5aCGyNGn5JLRbJf7oVQpho0");
        redisTemplate.opsForList().leftPush(RedisKey.USERLIST,"oaXaZ5bpAsmMy8KWX_bH3_fn3iVo");
        redisTemplate.opsForList().leftPush(RedisKey.USERLIST,"oaXaZ5eDkeJL-PVJE5feBH9d5ou4");
    }

    @Test
    public void del(){
        userDao.delUser("1111");
    }


    @Test
    public void select(){
        List<User> users=userDao.selectAll();
        users.forEach(i->{
            System.out.println(i.toString());
        });
        //System.out.println((User)redisTemplate.opsForValue().get(RedisKey.USER+"oaXaZ5Vj1FJEMI_YPMmifOXKFTYQ"));

        /*redisTemplate.opsForList().remove(RedisKey.USERLIST, -1, "123");
        redisTemplate.opsForList().range(RedisKey.USERLIST,0,-1).forEach(i->{
            System.out.println(i);
        });*/
    }


}
