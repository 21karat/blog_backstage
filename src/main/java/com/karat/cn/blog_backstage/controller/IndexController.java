package com.karat.cn.blog_backstage.controller;

import com.alibaba.fastjson.JSON;
import com.karat.cn.blog_backstage.bean.Blog;
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

        Blog blog1=new Blog("1","小明","这是博客标题1","https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2174909441,2495215020&fm=26&gp=0.jpg","这是博客内容",33,22,11,55);
        list.add(blog1);
        Blog blog2=new Blog("2","小明","这是博客标题2","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3139953554,3011511497&fm=26&gp=0.jpg","这是博客内容",33,22,11,55);
        list.add(blog2);
        Blog blog3=new Blog("3","小明","这是博客标题3","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2873269578,797009742&fm=26&gp=0.jpg","这是博客内容",33,22,11,55);
        list.add(blog3);
        Blog blog4=new Blog("4","小明","这是博客标题4","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2857172539,3231616089&fm=26&gp=0.jpg","这是博客内容",33,22,11,55);
        list.add(blog4);
        Blog blog5=new Blog("5","小明","这是博客标题8","https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=508387608,2848974022&fm=26&gp=0.jpg","这是博客内容",33,22,11,55);
        list.add(blog5);

        return JSON.toJSONString(new IndexResponseVo("200","请求成功",page,list));
    }

    @RequestMapping("getBlogDetail")
    public String getBlogDetail(int blogId){
        System.out.println("博客主键"+blogId);

        Blog blog1=new Blog("1","小明","这是博客标题1","https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2174909441,2495215020&fm=26&gp=0.jpg","这是博客内容",33,22,11,55);

        String a="<div style=\"background: #D3D3D3\">\n" +
                "        <div style=\"padding-left:15px;\"><br>\n" +
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
}
