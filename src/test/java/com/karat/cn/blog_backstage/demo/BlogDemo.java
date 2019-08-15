package com.karat.cn.blog_backstage.demo;

import com.karat.cn.blog_backstage.bean.Blog;
import com.karat.cn.blog_backstage.dao.BlogDao;
import com.karat.cn.blog_backstage.dao.TagDao;
import com.karat.cn.blog_backstage.util.IdUtil;
import com.karat.cn.blog_backstage.util.RedisKey;
import com.karat.cn.blog_backstage.util.TimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogDemo {

    @Autowired
    BlogDao blogDao;
    @Autowired
    TagDao tagDao;

    @Test
    public void addBlog(){
        Blog blog1=new Blog(IdUtil.getOrderIdByTime(),
                "21karat",
                "MyBatis框架",
                "http://img4.imgtn.bdimg.com/it/u=550144775,3054454397&fm=26&gp=0.jpg",
                "ORM框架：应用程序中的POJO对象和数据库表相互映射的框架称为对象关系映射框架(Object Relational Mapping)，Hibernate与Mybatis都可以称为ORM框架，只是Hibernate的设计理念是完全面向POJO的(全映射框架)，而MyBatis则不是(半映射框架)。",
                TimeUtil.formateDbDate(TimeUtil.systemtime()),
                100,
                100,
                100);
       ;
        Blog blog2=new Blog(IdUtil.getOrderIdByTime(),
                "21karat",
                "安装使用Redis过程中可能出现的错误收集",
                "http://img3.imgtn.bdimg.com/it/u=4282818983,1824637286&fm=26&gp=0.jpg",
                "本地telnet服务器redis端口6379不通（redis已启动 ） 关闭了服务器防火墙，在阿里云控制台中开放了6379端口，本地cmd中telnet服务器端口不通查看reids进程和端口，都是存在的。只是ip地址是127.0.0.1而不是0.0.0.0,只是本机能使用。",
                TimeUtil.formateDbDate(TimeUtil.systemtime()),
                50,
                50,
                50);

        Blog blog3=new Blog(IdUtil.getOrderIdByTime(),
                "21karat",
                "序列化与反序列化",
                "http://img4.imgtn.bdimg.com/it/u=2460742116,3466771586&fm=26&gp=0.jpg",
                "概念：把对象转化成字节序列的过程称之为对象的序列化，反之，称为反序列化。",
                TimeUtil.formateDbDate(TimeUtil.systemtime()),
                50,
                50,
                50);

        blogDao.addBlog(blog1);
        blogDao.addBlog(blog2);
        blogDao.addBlog(blog3);

        tagDao.addTag(blog1.getId(), RedisKey.HOT);
        tagDao.addTag(blog2.getId(), RedisKey.HOT);
        tagDao.addTag(blog3.getId(), RedisKey.HOT);

        tagDao.addTag(blog1.getId(), RedisKey.JAVA);
        tagDao.addTag(blog2.getId(), RedisKey.JAVA);
        tagDao.addTag(blog3.getId(), RedisKey.JAVA);
    }


    @Test
    public void selectBlog(){
        blogDao.selectAll().forEach(i->{
            System.out.println(i.toString());
        });
    }

    @Test
    public void updateBlog(){
        System.out.println( blogDao.selectById("1").toString());
        Blog blog=new Blog("1","海阳","Java 并发编程的挑战","http://img3.imgtn.bdimg.com/it/u=1582690715,667583212&fm=26&gp=0.jpg",
                "说明并发编程的世界中可能遇到的哪些问题，以及如何解决。并发的目的是让程序运行得更快，但并不是更多的线程就能让程序最大限度地并发执行。在多线程情景下，面临诸多挑战，如上下文切换、死锁、受限于软硬件资源等问题。","3",22,11,55);
        blogDao.updateBlog(blog);
        System.out.println( blogDao.selectById("1").toString());
    }


    @Test
    public void selectBlogByPage(){
        blogDao.selectAllByPage(1,2).forEach(i->{
            System.out.println(i.toString());
        });
    }
}
