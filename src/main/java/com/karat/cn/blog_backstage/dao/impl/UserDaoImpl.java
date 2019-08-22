package com.karat.cn.blog_backstage.dao.impl;

import com.karat.cn.blog_backstage.bean.User;
import com.karat.cn.blog_backstage.dao.UserDao;
import com.karat.cn.blog_backstage.util.RedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    RedisTemplate redisTemplate;

    //添加用户信息
    public void addUser(User user){
        redisTemplate.opsForValue().set(RedisKey.USER+user.getOpenId(),user);
        redisTemplate.opsForList().leftPush(RedisKey.USERLIST,user.getOpenId());
    }
    //根据用户openId查看用户信息
   public User selectById(String openId){
        return (User) redisTemplate.opsForValue().get(RedisKey.USER+openId);
   }
   //查看所有用户信息
   public List<User> selectAll(){
        List<User> users=new ArrayList<>();
        if(redisTemplate.hasKey(RedisKey.USERLIST)){
            redisTemplate.opsForList().range(RedisKey.USERLIST,0,-1).forEach(i->{
                users.add((User)redisTemplate.opsForValue().get(RedisKey.USER+i));
            });
        }
        return users;
   }

}
