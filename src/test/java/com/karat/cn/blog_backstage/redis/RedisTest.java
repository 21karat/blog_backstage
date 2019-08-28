package com.karat.cn.blog_backstage.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

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



    @Test
    public void listTest(){
        //在变量左边添加元素值。
        redisTemplate.opsForList().leftPush("123","set1");
        //集合数据数量
        System.out.println(redisTemplate.opsForList().size("123"));
        //获取集合指定位置的值。
        System.out.println(redisTemplate.opsForList().index("123",1));
        //获取指定区间的值。
        List<String> list =  redisTemplate.opsForList().range("123",0,-1);
        list.forEach(i->{
            System.out.println(i);
        });
        //把666放到123的set2前面，如果set2存在的话。
        redisTemplate.opsForList().leftPush("123","set2","666");
        //获取指定区间的值。
        List<String> list1 =  redisTemplate.opsForList().range("123",0,-1);
        list1.forEach(i->{
            System.out.println(i);
        });
        //向左边批量添加参数元素。
        redisTemplate.opsForList().leftPushAll("123","w","x","y");
        List<String> list2 =  redisTemplate.opsForList().range("123",0,-1);//获取指定区间的值。
        list2.forEach(i->{
            System.out.println(i);
        });

        // 移除集合中的左边第一个元素。
        Object popValue = redisTemplate.opsForList().leftPop("123");
        System.out.print("通过leftPop(K key)方法移除的元素是:" + popValue);
        System.out.println(",剩余的元素是:" + redisTemplate.opsForList().range("123",0,-1));
        //移除集合中右边的元素。
        popValue = redisTemplate.opsForList().rightPop("123");
        System.out.print("通过rightPop(K key)方法移除的元素是:" + popValue);
        System.out.println(",剩余的元素是:" + redisTemplate.opsForList().range("123",0,-1));
        // 在集合的指定位置插入元素,如果指定位置已有元素，则覆盖，没有则新增，超过集合下标+n则会报错。
        redisTemplate.opsForList().set("123",3,"20");
        System.out.println(",剩余的元素是:" + redisTemplate.opsForList().range("123",0,-1));

    }
}
