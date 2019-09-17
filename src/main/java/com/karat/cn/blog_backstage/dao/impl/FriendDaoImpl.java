package com.karat.cn.blog_backstage.dao.impl;

import com.karat.cn.blog_backstage.bean.Friend;
import com.karat.cn.blog_backstage.dao.FriendDao;
import com.karat.cn.blog_backstage.util.RedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendDaoImpl implements FriendDao {

    @Autowired
    RedisTemplate redisTemplate;

    //查看所有友链
    public List<Friend> selectAll(){
        if (redisTemplate.hasKey(RedisKey.FRIEND)) {
            return (List<Friend>)redisTemplate.opsForValue().get(RedisKey.FRIEND);
        }else{
            return new ArrayList<>();
        }
    }
    //添加友链
    public void add(Friend friend){
        List<Friend> list=new ArrayList<>();
        if (redisTemplate.hasKey(RedisKey.FRIEND)) {
            list=(List<Friend>)redisTemplate.opsForValue().get(RedisKey.FRIEND);
        }
        list.add(friend);
        redisTemplate.opsForValue().set(RedisKey.FRIEND,list);
    }
    //删除友链
    public List<Friend> delFriend(String id){
        List<Friend> list=new ArrayList<>();
        if (redisTemplate.hasKey(RedisKey.FRIEND)) {
            list=(List<Friend>)redisTemplate.opsForValue().get(RedisKey.FRIEND);
        }
        List<Friend> friends = list.stream().filter(friend -> !id.equals(friend.getId())).collect(Collectors.toList());
        redisTemplate.opsForValue().set(RedisKey.FRIEND,friends);
        return friends;
    }
    //修改友链
    public void updateFriend(Friend friend){
        List<Friend> list=new ArrayList<>();
        if (redisTemplate.hasKey(RedisKey.FRIEND)) {
            list=(List<Friend>)redisTemplate.opsForValue().get(RedisKey.FRIEND);
        }
        list.forEach(i->{
            if(i.getId().equals(friend.getId())){
                i.setId(friend.getId());
                i.setAdrr(friend.getAdrr());
                i.setName(friend.getName());
            }
        });
        redisTemplate.opsForValue().set(RedisKey.FRIEND,list);
    }
}
