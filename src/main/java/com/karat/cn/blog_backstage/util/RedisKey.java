package com.karat.cn.blog_backstage.util;

public class RedisKey {

    //博客头(每条博客对应一条数据)
    public static final String BLOG="blog_";
    //首页博客列表(存博客ID的List)
    public static final String BLOGLIST="blog_list";


    //java标签（+博客ID）
    public static final String JAVA="java";
    //python标签（+博客ID）
    public static final String PYTHON="python";
    //web标签（+博客ID）
    public static final String WEB="web";
    //其它标签（+博客ID）
    public static final String OTHER="other";
    //热门标签（+博客ID）
    public static final String HOT="hot";

    //评论（+评论ID）
    public static final String COMMENT="comment_";
    //评论集合（+博客ID）
    public static final String COMMENTLIST="comment_list_";


    //用户
    public static final String USER="user_";
    //用户openId集合
    public static final String USERLIST="user_list";


    //友链
    public static final String FRIEND="friend";
    //联系作者
    public static final String AUTHOR="author";

    //博客详情中的Html(+博客ID)
    public static final String BLOGHTML="bloghtml_";

}
