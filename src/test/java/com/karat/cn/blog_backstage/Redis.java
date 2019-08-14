package com.karat.cn.blog_backstage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Redis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    public void testDemo()  {
        // 保存字符串
       /* stringRedisTemplate.opsForValue().set("bbb", "222");
        stringRedisTemplate.opsForValue().set("b", "123456");
        stringRedisTemplate.opsForValue().set("bb", "88888");*/
        System.out.println(stringRedisTemplate.opsForValue().get("b"));
    }
}
