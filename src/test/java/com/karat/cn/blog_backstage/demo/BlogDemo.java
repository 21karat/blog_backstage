package com.karat.cn.blog_backstage.demo;

import com.karat.cn.blog_backstage.bean.Blog;
import com.karat.cn.blog_backstage.dao.BlogDao;
import com.karat.cn.blog_backstage.dao.TagDao;
import com.karat.cn.blog_backstage.util.HtmlUtil;
import com.karat.cn.blog_backstage.util.IdUtil;
import com.karat.cn.blog_backstage.util.RedisKey;
import com.karat.cn.blog_backstage.util.TimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogDemo {

    @Autowired
    BlogDao blogDao;
    @Autowired
    TagDao tagDao;

    @Test
    public void addBlog(){
        /*========================================================================================================*/
        Blog blog1=new Blog(IdUtil.getOrderIdByTime(),
                "21karat",
                "Flask框架初识记录",
                "http://img1.imgtn.bdimg.com/it/u=3484976427,1112118554&fm=26&gp=0.jpg",
                "1.打开编译软件JetBrains PyCharm 2019.1.1 x64",
                TimeUtil.formateDbDate(TimeUtil.systemtime()),
                100,
                100,
                100);
        //添加博客
        blogDao.addBlog(blog1);
       ;//添加博客对应的详情HTML
        blogDao.addBlogHtml(blog1.getId(), HtmlUtil.getHtml("E:\\JavaEE\\blog_backstage\\src\\main\\resources\\templates\\Flask.html"));
        //添加标签
        tagDao.addTag(blog1.getId(), RedisKey.PYTHON);

        /*========================================================================================================*/
        Blog blog2=new Blog(IdUtil.getOrderIdByTime(),
                "21karat",
                "Python与Web交互基础笔记",
                "http://img3.imgtn.bdimg.com/it/u=3055827852,3037196605&fm=26&gp=0.jpg",
                "1.Jinji2模板引擎(Falsk内置模板引擎，来源与另一个框架Django)例：render_template()中传模板以及入参，那么在模板中可以直接通过{{}}来使用",
                TimeUtil.formateDbDate(TimeUtil.systemtime()),
                50,
                50,
                50);
        //添加博客
        blogDao.addBlog(blog2);
        //添加博客对应的详情HTML
        blogDao.addBlogHtml(blog2.getId(), HtmlUtil.getHtml("E:\\JavaEE\\blog_backstage\\src\\main\\resources\\templates\\PythonWeb.html"));
        //添加标签
        tagDao.addTag(blog2.getId(), RedisKey.PYTHON);
        tagDao.addTag(blog2.getId(), RedisKey.HOT);
        /*========================================================================================================*/
        Blog blog3=new Blog(IdUtil.getOrderIdByTime(),
                "21karat",
                "序列化与反序列化",
                "http://img0.imgtn.bdimg.com/it/u=3624525885,3959898217&fm=26&gp=0.jpg",
                "概念：把对象转化成字节序列的过程称之为对象的序列化，反之，称为反序列化。",
                TimeUtil.formateDbDate(TimeUtil.systemtime()),
                50,
                50,
                50);
        //添加博客
        blogDao.addBlog(blog3);
        //添加博客对应的详情HTML
        blogDao.addBlogHtml(blog3.getId(), HtmlUtil.getHtml("E:\\JavaEE\\blog_backstage\\src\\main\\resources\\templates\\Serializable.html"));
        //添加标签
        tagDao.addTag(blog3.getId(), RedisKey.JAVA);
        tagDao.addTag(blog3.getId(), RedisKey.HOT);
        /*========================================================================================================*/
        Blog blog4=new Blog(IdUtil.getOrderIdByTime(),
                "21karat",
                "Session与Cookie",
                "http://img3.imgtn.bdimg.com/it/u=2540499616,1955521581&fm=26&gp=0.jpg",
                "session概念：在WEB开发中，服务器可以为每个用户浏览器创建一个会话对象（session对象），注意：一个浏览器独占一个session对象(默认情况下)。因此，在需要保存用户数据时，服务器程序可以把用户数据写到用户浏览器独占的session中，当用户使用浏览器访问其它程序时，其它程序可以从用户的session中取出该用户的数据，为用户服务。session对象以键值方式存储在ConcurrentHashMap中。",
                TimeUtil.formateDbDate(TimeUtil.systemtime()),
                50,
                50,
                50);
        //添加博客
        blogDao.addBlog(blog4);
        //添加博客对应的详情HTML
        blogDao.addBlogHtml(blog4.getId(), HtmlUtil.getHtml("E:\\JavaEE\\blog_backstage\\src\\main\\resources\\templates\\Seeion.html"));
        //添加标签
        tagDao.addTag(blog4.getId(), RedisKey.JAVA);

        /*========================================================================================================*/
        Blog blog5=new Blog(IdUtil.getOrderIdByTime(),
                "21karat",
                "CGLIB动态代理模式",
                "http://img1.imgtn.bdimg.com/it/u=2363682123,3333303428&fm=26&gp=0.jpg",
                "概念：第三方技术CGLIB动态代理和JDK代理不同的是，JDK代理需要提供接口，而CGLIB代理不需要。它只需要一个非抽象类就能实现动态代理",
                TimeUtil.formateDbDate(TimeUtil.systemtime()),
                50,
                50,
                50);
        //添加博客
        blogDao.addBlog(blog5);
        //添加博客对应的详情HTML
        blogDao.addBlogHtml(blog5.getId(), HtmlUtil.getHtml("E:\\JavaEE\\blog_backstage\\src\\main\\resources\\templates\\CGLIB.html"));
        //添加标签
        tagDao.addTag(blog5.getId(), RedisKey.JAVA);
        tagDao.addTag(blog5.getId(), RedisKey.HOT);
        /*========================================================================================================*/
        Blog blog6=new Blog(IdUtil.getOrderIdByTime(),
                "21karat",
                "小程序渲染问题:ios显示安卓不显示",
                "http://img1.imgtn.bdimg.com/it/u=3750785723,2438777544&fm=26&gp=0.jpg",
                "测试库转到正式库后添加数据，小程序数据渲染不出来，但是测试库没问题，ios数据能显示，没问题，但是安卓显示没数据。排除是服务器https证书问题，如果是证书问题，小程序会直接调不了接口。百度一堆解决办法，最靠谱点的解决办法：https://www.jianshu.com/p/3203b98807b4前后端根据方法排查问题，仍然解决不了。",
                TimeUtil.formateDbDate(TimeUtil.systemtime()),
                50,
                50,
                50);
        //添加博客
        blogDao.addBlog(blog6);
        //添加博客对应的详情HTML
        blogDao.addBlogHtml(blog6.getId(), HtmlUtil.getHtml("E:\\JavaEE\\blog_backstage\\src\\main\\resources\\templates\\IOS.html"));
        //添加标签
        tagDao.addTag(blog6.getId(), RedisKey.WEB);
        tagDao.addTag(blog6.getId(), RedisKey.HOT);
        /*========================================================================================================*/
        Blog blog7=new Blog(IdUtil.getOrderIdByTime(),
                "21karat",
                "Java 内存模型",
                "http://img2.imgtn.bdimg.com/it/u=3983813589,2827822077&fm=26&gp=0.jpg",
                "在并发编程中，需要处理两个关键问题：1. 线程之间如何通信；2.线程之间如何同步。\n" +
                        "\n" +
                        "通信，是指线程间以何种机制交换信息，如 共享内存 和消息传递。\n" +
                        "\n" +
                        "共享内存：在此模型中，线程之间共享程序的公共状态，通过写 - 读内存中的公共状态进行隐式通信。\n" +
                        "\n" +
                        "消息传递：在此模型中，线程间没有公共状态，只能通过发送消息来显式进行通信。\n" +
                        "\n" +
                        "同步，指程序中用于控制不同线程间操作发生相对顺序的机制。\n" +
                        "\n" +
                        "共享内存：在此模型中，同步是显式进行的，程序员必须显式指定某个方法或某段代码需要在线程之间互斥执行。\n" +
                        "\n" +
                        "消息传递：在此模型中，由于消息发送必须在消息接收之前，因此同步是隐式的。",
                TimeUtil.formateDbDate(TimeUtil.systemtime()),
                50,
                50,
                50);
        //添加博客
        blogDao.addBlog(blog7);
        //添加博客对应的详情HTML
        blogDao.addBlogHtml(blog7.getId(), HtmlUtil.getHtml("E:\\JavaEE\\blog_backstage\\src\\main\\resources\\templates\\Java.html"));
        //添加标签
        tagDao.addTag(blog7.getId(), RedisKey.JAVA);

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
