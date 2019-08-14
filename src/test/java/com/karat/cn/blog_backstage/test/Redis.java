package com.karat.cn.blog_backstage.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Redis {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Test
    public void addString1()  {
        // 添加字符串
        stringRedisTemplate.opsForValue().set("bbb", "222");
        System.out.println(stringRedisTemplate.opsForValue().get("b"));
    }
    @Test
    public void addString2()  {
        // 添加字符串
        redisTemplate.opsForValue().set("kk","3333");
        System.out.println(redisTemplate.opsForValue().get("kk"));
    }
    @Test
    public void delDemo()  {
        // 删除字符串
        System.out.println(redisTemplate.opsForValue().get("b"));
        System.out.println(redisTemplate.delete("b"));
    }
    @Test
    public void updateDemo()  {
        //更新字符串
        System.out.println(redisTemplate.opsForValue().get("bb"));
        redisTemplate.opsForValue().set("bb","dd");
        System.out.println(redisTemplate.opsForValue().get("bb"));
    }
    @Test
    public void selectDemo()  {
        //更新字符串
        System.out.println(redisTemplate.opsForValue().get("bb"));
        redisTemplate.opsForValue().set("bb","dd");
        System.out.println(redisTemplate.opsForValue().get("bb"));
    }


}
