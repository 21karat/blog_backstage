package com.karat.cn.blog_backstage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.karat.cn.blog_backstage.bean.Blog;
import com.karat.cn.blog_backstage.bean.Comment;
import com.karat.cn.blog_backstage.vo.CommentResponseVo;
import com.karat.cn.blog_backstage.vo.DetailResponseVo;
import com.karat.cn.blog_backstage.vo.IndexResponseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {


    /**
     * 博客列表
     * @return
     */
    @RequestMapping("getBlogList")
    public String getBlogList(int limit,int page){
        System.out.println("当前页数："+page+"--当前条数："+limit);

        List<Blog> list=new ArrayList<>();

        Blog blog1=new Blog("1","德泽","《Spring Security》 读书笔记 - 目录","http://img4.imgtn.bdimg.com/it/u=2905893513,2695425341&fm=26&gp=0.jpg","SpringSecurity 是一个强大的、高度可定制的身份验证和访问控制框架，它是确保基于 Spring 的应用程序安全的事实标准。\n" +
                "Spring Security is a powerful and highly customizable authentication and access-control framework. It is the de-facto standard for securing Spring-based applications",33,22,11,55);
        list.add(blog1);
        Blog blog2=new Blog("2","海阳","Java 并发编程的挑战","http://img3.imgtn.bdimg.com/it/u=1582690715,667583212&fm=26&gp=0.jpg",
                "说明并发编程的世界中可能遇到的哪些问题，以及如何解决。并发的目的是让程序运行得更快，但并不是更多的线程就能让程序最大限度地并发执行。在多线程情景下，面临诸多挑战，如上下文切换、死锁、受限于软硬件资源等问题。",33,22,11,55);
        list.add(blog2);
        Blog blog3=new Blog("3","浩皛","Java 并发机制的底层实现原理","http://img0.imgtn.bdimg.com/it/u=2738234332,2025993528&fm=26&gp=0.jpg",
                "Java 代码在编译之后会变成 Java 字节码，字节码被类加载器加载到 JVM 里，JVM 执行字节码，最终转化为汇编指令在 CPU 上执行。Java 中所使用的并发机制依赖于 JVM 的实现和 CPU 的指令。",33,22,11,55);
        list.add(blog3);
        Blog blog4=new Blog("1","涵蓄","Cache Control","http://img5.imgtn.bdimg.com/it/u=3495002897,1124108098&fm=26&gp=0.jpg",
                "缓存控制，意味着用户是否可以通过浏览器缓存来查看经过身份验证的页面。默认情况下，是不使用缓存的，入股你希望缓存特定的响应，那么可以在应用程序中进行如下配置：",33,22,11,55);
        list.add(blog4);
        Blog blog5=new Blog("2","瀚钰","SpringSecurity 中的核心组件","http://img0.imgtn.bdimg.com/it/u=2638977175,1485789245&fm=26&gp=0.jpg",
                "通过前四章简单介绍了下 SpringSecurity 的命名空间配置和Java 配置，已经可以简单一个基于 Spring Security 的应用程序。下面，将会研究其中一些在整个框架中使用的中心接口、类和抽象概念，了解它们如何协同工作，以支持 Spring Security 中的身份验证和访问控制。",33,22,11,55);
        list.add(blog5);
        Blog blog6=new Blog("3","浩歌","代理模式","http://img1.imgtn.bdimg.com/it/u=308206753,3011592900&fm=26&gp=0.jpg",
                "代理模式是常用的 对象结构型设计模式 之一，当无法直接访问某个对象时，可以通过一个代理对象来间接访问。为了保证客户端使用的透明性，所访问的真实对象与代理对象需要实现相同的接口。代理模式根据使用目的，又可以分为：保护代理、远程代理、虚拟代理、缓冲代理等。",33,22,11,55);
        list.add(blog6);
        Blog blog7=new Blog("1","德泽","《Spring Security》 读书笔记 - 目录","http://img4.imgtn.bdimg.com/it/u=2905893513,2695425341&fm=26&gp=0.jpg","SpringSecurity 是一个强大的、高度可定制的身份验证和访问控制框架，它是确保基于 Spring 的应用程序安全的事实标准。\n" +
                "Spring Security is a powerful and highly customizable authentication and access-control framework. It is the de-facto standard for securing Spring-based applications",33,22,11,55);
        list.add(blog7);
        Blog blog8=new Blog("2","海阳","Java 并发编程的挑战","http://img3.imgtn.bdimg.com/it/u=1582690715,667583212&fm=26&gp=0.jpg",
                "说明并发编程的世界中可能遇到的哪些问题，以及如何解决。并发的目的是让程序运行得更快，但并不是更多的线程就能让程序最大限度地并发执行。在多线程情景下，面临诸多挑战，如上下文切换、死锁、受限于软硬件资源等问题。",33,22,11,55);
        list.add(blog8);
        Blog blog9=new Blog("3","王 冉","这是博客标题8","http://img4.imgtn.bdimg.com/it/u=2460742116,3466771586&fm=26&gp=0.jpg","这是博客内容",33,22,11,55);
        list.add(blog9);
        Blog blog10=new Blog("1","蒋锡培","微信小程序生成带参二维码","http://img0.imgtn.bdimg.com/it/u=1255337905,586002257&fm=26&gp=0.jpg","实现微信小程序中的海报功能，海报中有一个通过扫码跳转到自己小程序的二维码，用户保存海报到本地在朋友圈分享后就可以通过扫码进入小程序。",33,22,11,55);
        list.add(blog10);
        Blog blog11=new Blog("2","向文波","微信小程序获取用户的unionId以及手机号","http://img5.imgtn.bdimg.com/it/u=2769396975,537242780&fm=26&gp=0.jpg","解密手机号与unionId分别写在2个接口中(解密的入参不同)，unionId解不出来要去检查一下你的微信开放平台(微信开放平台)是否有绑定微信小程序。",33,22,11,55);
        list.add(blog11);
        Blog blog12=new Blog("3","王 冉","小程序渲染问题:ios显示安卓不显示","http://img4.imgtn.bdimg.com/it/u=2460742116,3466771586&fm=26&gp=0.jpg","运维在后台添加数据时，直接复制粘贴会导致数据异常，正常看数据没问题，但是返回json给前端会渲染不了，除此之外，添加数据时带上回车键也会出现同样渲染不出来的情况(ios渲染不出来)。",33,22,11,55);
        list.add(blog12);

        return JSON.toJSONString(new IndexResponseVo("200","请求成功",page,list));
    }

    /**
     * 博客详情
     * @param blogId
     * @return
     */
    @RequestMapping("getBlogDetail")
    public String getBlogDetail(int blogId){
        System.out.println("博客主键"+blogId);

        Blog blog1=new Blog("1","小明","种类英文怎么写及英语单词沪江词","https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2174909441,2495215020&fm=26&gp=0.jpg","这是博客内容",33,22,11,55);

        String a="<div style=\"background: #EEEED1\">\n" +
                "        <div style=\"padding-left:15px;margin-right:15px;margin-top:-5px;margin-bottom:15px\"><br>\n" +
                "        <span>最近哼多人都在完绝地求生，缺是第一次玩很多人都晕3D，有些进场打CF的人玩起来比起没玩过枪战的人更加适合这款游戏。</span><br></div></div>\n" +
                "    <span style=\"font-weight:bold;font-size:12px\">关于小程序开发</span>\n" +
                "    <ul>\n" +
                "        <li>Java</li>\n" +
                "        <li>HTML</li>\n" +
                "        <li>Python</li>\n" +
                "    </ul> \n" +
                "        <img src=\"http://img4.imgtn.bdimg.com/it/u=1451023851,4108165595&fm=26&gp=0.jpg\"></img>  \n" +
                "    <p>微信小程序如何解析HTML富文本（使用wxParse解析富文本的demo）微信小程序如何解析HTML富文本（使用wxParse解析富文本的demo）微信小程序如何解析HTML富文本（使用wxParse解析富文本的demo）</p>  \n" +
                "    <p>微信小程序如何解析HTML富文本（使用wxParse解析富文本的demo）微信小程序如何解析HTML富文本（使用wxParse解析富文本的demo）微信小程序如何解析HTML富文本（使用wxParse解析富文本的demo）</p>  \n" +
                "        <img src=\"http://img5.imgtn.bdimg.com/it/u=69050753,1382655822&fm=26&gp=0.jpg\"></img>  \n" +
                "    <p>近两年，小青柑的火爆有目共睹，娇小玲珑的产品形态、便携式的消费场景、柑与茶结合的时尚方式以及独特的口感和养生功效，都在顺应着目前年轻化、多元化、便携化的茶叶消费市场需求，让它成为了一大爆品。</p> ";
        return JSON.toJSONString(new DetailResponseVo("200","请求成功",a,blog1));
    }

    /**
     * 根据博客ID获取评论
     * @return
     */
    @RequestMapping("getCommentByBlog")
    public CommentResponseVo getCommentByBlog(String blogId){
        System.out.println(blogId);
        Comment comment1=new Comment("1","http://img5.imgtn.bdimg.com/it/u=1460089143,1479780884&fm=26&gp=0.jpg","小明","我是小明我是小明，收到请回答","2019-06-10","1");
        Comment comment2=new Comment("2","http://img5.imgtn.bdimg.com/it/u=3389683750,3564498893&fm=26&gp=0.jpg","小强","人生若只如初见，何事秋风悲画扇。寂寞空庭春欲晚，梨花满地不开门。寂寞空庭春欲晚，梨花满地不开门。","2019-06-10","1");
        Comment comment3=new Comment("3","http://img3.imgtn.bdimg.com/it/u=1677901248,1634112591&fm=26&gp=0.jpg","小红","曾经沧海难为水，除却巫山不是云。山重水复疑无路，柳暗花明又一村。山重水复疑无路，柳暗花明又一村。","2019-06-10","1");
        Comment comment4=new Comment("4","http://img5.imgtn.bdimg.com/it/u=3230957845,3313776986&fm=26&gp=0.jpg","小黄","问君能有几多愁？恰似一江春水向东流。枯藤老树昏鸦，小桥流水人家，古道西风瘦马。枯藤老树昏鸦，小桥流水人家，古道西风瘦马。","2019-06-10","1");

        List<Comment> list=new ArrayList<>();
        list.add(comment1);
        list.add(comment2);
        list.add(comment3);
        list.add(comment4);

        CommentResponseVo vo=new CommentResponseVo(4,list);
        return vo;
    }

    /**
     * 添加评论
     * @param blogId
     * @param userId
     * @param content
     * @return
     */
    @RequestMapping("addComment")
    public JSONObject addComment(String blogId, String userId, String content){
        JSONObject object=new JSONObject();
        System.out.println("博客ID："+blogId+"用户ID："+userId+"内容："+content);

        object.put("code","200");
        object.put("msg","请求成功");
        return object;
    }


    /**
     * 根据标签获取列表
     * @param limit
     * @param page
     * @param filter
     * @return
     */
    @RequestMapping("getBlogListByTab")
    public String getBlogListByTab(int limit,int page,String filter){
        System.out.println("当前页数："+page+"--当前条数："+limit+"filter:"+filter);
        List<Blog> list=new ArrayList<>();
        switch (filter) {
            case "java":
                Blog blog1=new Blog("1","德泽","《Spring Security》 读书笔记 - 目录","http://img4.imgtn.bdimg.com/it/u=2905893513,2695425341&fm=26&gp=0.jpg","SpringSecurity 是一个强大的、高度可定制的身份验证和访问控制框架，它是确保基于 Spring 的应用程序安全的事实标准。\n" +
                        "Spring Security is a powerful and highly customizable authentication and access-control framework. It is the de-facto standard for securing Spring-based applications",33,22,11,55);
                list.add(blog1);
                Blog blog2=new Blog("2","海阳","Java 并发编程的挑战","http://img3.imgtn.bdimg.com/it/u=1582690715,667583212&fm=26&gp=0.jpg",
                        "说明并发编程的世界中可能遇到的哪些问题，以及如何解决。并发的目的是让程序运行得更快，但并不是更多的线程就能让程序最大限度地并发执行。在多线程情景下，面临诸多挑战，如上下文切换、死锁、受限于软硬件资源等问题。",33,22,11,55);
                list.add(blog2);
                Blog blog3=new Blog("3","浩皛","Java 并发机制的底层实现原理","http://img0.imgtn.bdimg.com/it/u=2738234332,2025993528&fm=26&gp=0.jpg",
                        "Java 代码在编译之后会变成 Java 字节码，字节码被类加载器加载到 JVM 里，JVM 执行字节码，最终转化为汇编指令在 CPU 上执行。Java 中所使用的并发机制依赖于 JVM 的实现和 CPU 的指令。",33,22,11,55);
                list.add(blog3);
                break;
            case "web":
                Blog blog4=new Blog("1","涵蓄","Cache Control","http://img5.imgtn.bdimg.com/it/u=3495002897,1124108098&fm=26&gp=0.jpg",
                        "缓存控制，意味着用户是否可以通过浏览器缓存来查看经过身份验证的页面。默认情况下，是不使用缓存的，入股你希望缓存特定的响应，那么可以在应用程序中进行如下配置：",33,22,11,55);
                list.add(blog4);
                Blog blog5=new Blog("2","瀚钰","SpringSecurity 中的核心组件","http://img0.imgtn.bdimg.com/it/u=2638977175,1485789245&fm=26&gp=0.jpg",
                        "通过前四章简单介绍了下 SpringSecurity 的命名空间配置和Java 配置，已经可以简单一个基于 Spring Security 的应用程序。下面，将会研究其中一些在整个框架中使用的中心接口、类和抽象概念，了解它们如何协同工作，以支持 Spring Security 中的身份验证和访问控制。",33,22,11,55);
                list.add(blog5);
                Blog blog6=new Blog("3","浩歌","代理模式","http://img1.imgtn.bdimg.com/it/u=308206753,3011592900&fm=26&gp=0.jpg",
                        "代理模式是常用的 对象结构型设计模式 之一，当无法直接访问某个对象时，可以通过一个代理对象来间接访问。为了保证客户端使用的透明性，所访问的真实对象与代理对象需要实现相同的接口。代理模式根据使用目的，又可以分为：保护代理、远程代理、虚拟代理、缓冲代理等。",33,22,11,55);
                list.add(blog6);
                break;
            case "python":
                Blog blog7=new Blog("1","德泽","《Spring Security》 读书笔记 - 目录","http://img4.imgtn.bdimg.com/it/u=2905893513,2695425341&fm=26&gp=0.jpg","SpringSecurity 是一个强大的、高度可定制的身份验证和访问控制框架，它是确保基于 Spring 的应用程序安全的事实标准。\n" +
                        "Spring Security is a powerful and highly customizable authentication and access-control framework. It is the de-facto standard for securing Spring-based applications",33,22,11,55);
                list.add(blog7);
                Blog blog8=new Blog("2","海阳","Java 并发编程的挑战","http://img3.imgtn.bdimg.com/it/u=1582690715,667583212&fm=26&gp=0.jpg",
                        "说明并发编程的世界中可能遇到的哪些问题，以及如何解决。并发的目的是让程序运行得更快，但并不是更多的线程就能让程序最大限度地并发执行。在多线程情景下，面临诸多挑战，如上下文切换、死锁、受限于软硬件资源等问题。",33,22,11,55);
                list.add(blog8);
                Blog blog9=new Blog("3","王 冉","这是博客标题8","http://img4.imgtn.bdimg.com/it/u=2460742116,3466771586&fm=26&gp=0.jpg","这是博客内容",33,22,11,55);
                list.add(blog9);
                break;
            case "other":
                Blog blog10=new Blog("1","蒋锡培","微信小程序生成带参二维码","http://img0.imgtn.bdimg.com/it/u=1255337905,586002257&fm=26&gp=0.jpg","实现微信小程序中的海报功能，海报中有一个通过扫码跳转到自己小程序的二维码，用户保存海报到本地在朋友圈分享后就可以通过扫码进入小程序。",33,22,11,55);
                list.add(blog10);
                Blog blog11=new Blog("2","向文波","微信小程序获取用户的unionId以及手机号","http://img5.imgtn.bdimg.com/it/u=2769396975,537242780&fm=26&gp=0.jpg","解密手机号与unionId分别写在2个接口中(解密的入参不同)，unionId解不出来要去检查一下你的微信开放平台(微信开放平台)是否有绑定微信小程序。",33,22,11,55);
                list.add(blog11);
                Blog blog12=new Blog("3","王 冉","小程序渲染问题:ios显示安卓不显示","http://img4.imgtn.bdimg.com/it/u=2460742116,3466771586&fm=26&gp=0.jpg","运维在后台添加数据时，直接复制粘贴会导致数据异常，正常看数据没问题，但是返回json给前端会渲染不了，除此之外，添加数据时带上回车键也会出现同样渲染不出来的情况(ios渲染不出来)。",33,22,11,55);
                list.add(blog12);
                break;
            default:
                Blog blog13=new Blog("1","涵蓄","Cache Control","http://img5.imgtn.bdimg.com/it/u=3495002897,1124108098&fm=26&gp=0.jpg",
                        "缓存控制，意味着用户是否可以通过浏览器缓存来查看经过身份验证的页面。默认情况下，是不使用缓存的，入股你希望缓存特定的响应，那么可以在应用程序中进行如下配置：",33,22,11,55);
                list.add(blog13);
                Blog blog14=new Blog("2","瀚钰","SpringSecurity 中的核心组件","http://img0.imgtn.bdimg.com/it/u=2638977175,1485789245&fm=26&gp=0.jpg",
                        "通过前四章简单介绍了下 SpringSecurity 的命名空间配置和Java 配置，已经可以简单一个基于 Spring Security 的应用程序。下面，将会研究其中一些在整个框架中使用的中心接口、类和抽象概念，了解它们如何协同工作，以支持 Spring Security 中的身份验证和访问控制。",33,22,11,55);
                list.add(blog14);
                Blog blog15=new Blog("3","浩歌","代理模式","http://img1.imgtn.bdimg.com/it/u=308206753,3011592900&fm=26&gp=0.jpg",
                        "代理模式是常用的 对象结构型设计模式 之一，当无法直接访问某个对象时，可以通过一个代理对象来间接访问。为了保证客户端使用的透明性，所访问的真实对象与代理对象需要实现相同的接口。代理模式根据使用目的，又可以分为：保护代理、远程代理、虚拟代理、缓冲代理等。",33,22,11,55);
                list.add(blog15);
        }



        return JSON.toJSONString(new IndexResponseVo("200","请求成功",page,list));
    }
}
