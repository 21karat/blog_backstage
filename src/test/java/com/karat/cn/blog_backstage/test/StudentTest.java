package com.karat.cn.blog_backstage.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {



    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 查询所有
     */
    @Test
    public void findAll() {
        String key = "student";
        //查看对象
        List<Student> list=new ArrayList<>();
        //查看所有
        ListOperations<String, Student> operations = redisTemplate.opsForList();
        //缓存存在
        if (redisTemplate.hasKey(key)) {
            list=operations.range(key, 0, -1);//转成对象
        }
        list.forEach(i->{
            System.out.println(i.toString());//输出
        });
    }

    /**
     * 根据id查询学生信息
     */
    @Test
    public void findById() {
        String key = "student_" + 1;
        //输出对象
        Student student=null;
        //实例
        ValueOperations<String, Student> operations = redisTemplate.opsForValue();
        //缓存存在
        if (redisTemplate.hasKey(key)) {
            student=operations.get(key);//获取该键对应的对象
        }
        System.out.println(student.toString());
    }


    /**
     * 根据id删除学生信息
     */
    @Test
    public void del() {
        boolean flag=false;
        //缓存存在
        String key = "student_" + 1;
        if (redisTemplate.hasKey(key)) {
            //删除对应缓存
            flag=redisTemplate.delete(key);
        }
        System.out.println(flag);
    }

    /**
     * 修改学生信息
     */
    @Test
    public void modify() {
        //修改对象
        Student student=new Student(1,"荆轲123","男");
        //实例
        ValueOperations operations = redisTemplate.opsForValue();
        //缓存存在
        String key = "student_" +1;
        if (redisTemplate.hasKey(key)) {
            //更新缓存
            operations.set(key, student);
        }
    }

    /**
     * 添加学生信息
     */
    @Test
    public void add() {
        String key = "student_";
        //修改对象
        Student student=new Student(1,"荆轲","男");
        //实例
        ValueOperations operations = redisTemplate.opsForValue();
        //缓存不存在
        if (!redisTemplate.hasKey(key+student.getId())) {
            //添加缓存
            operations.set(key+student.getId(), student);
        }
    }

    /**
     * 添加学生集合信息
     */
    @Test
    public void addList() {
        String key = "student_list_";
        //对象集合
        List list=new ArrayList();
        Student student1=new Student(1,"荆轲","男");
        Student student2=new Student(2,"小明","男");
        Student student3=new Student(3,"小红","女");
        list.add(student1);
        list.add(student2);
        list.add(student3);
        //实例
        ValueOperations operations = redisTemplate.opsForValue();
        //缓存不存在
        if (!redisTemplate.hasKey(key+1)) {
            //添加缓存
            operations.set(key+1,list);
        }
        //查看添加的list
        List<Student> userList=(List<Student>)operations.get(key+1);
        userList.forEach(i->{
            System.out.println(i.toString());
        });
    }


}
