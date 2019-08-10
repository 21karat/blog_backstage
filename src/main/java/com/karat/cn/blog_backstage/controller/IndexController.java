package com.karat.cn.blog_backstage.controller;

import com.alibaba.fastjson.JSON;
import com.karat.cn.blog_backstage.bean.Blog;
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
    public String getBlogList(){
        List<Blog> list=new ArrayList<>();

        Blog blog1=new Blog("1","小明","这是博客标题1","https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4135306546,2812379356&fm=26&gp=0.jpg","这是博客内容",33,22,11,55);
        list.add(blog1);
        Blog blog2=new Blog("2","小明","这是博客标题2","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1293554423,269876203&fm=26&gp=0.jpg","这是博客内容",33,22,11,55);
        list.add(blog2);
        Blog blog3=new Blog("3","小明","这是博客标题3","https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1183798264,2816669890&fm=26&gp=0.jpg","这是博客内容",33,22,11,55);
        list.add(blog3);
        Blog blog4=new Blog("4","小明","这是博客标题4","https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2997339819,2004274761&fm=26&gp=0.jpg","这是博客内容",33,22,11,55);
        list.add(blog4);
        Blog blog5=new Blog("5","小明","这是博客标题8","https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4135306546,2812379356&fm=26&gp=0.jpg","这是博客内容",33,22,11,55);
        list.add(blog5);

        return JSON.toJSONString(new IndexResponseVo("200","请求成功",list));
    }

}
