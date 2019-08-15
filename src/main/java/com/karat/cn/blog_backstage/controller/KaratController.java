package com.karat.cn.blog_backstage.controller;

import com.alibaba.fastjson.JSONObject;
import com.karat.cn.blog_backstage.bean.Blog;
import com.karat.cn.blog_backstage.bean.Comment;
import com.karat.cn.blog_backstage.bean.User;
import com.karat.cn.blog_backstage.dao.BlogDao;
import com.karat.cn.blog_backstage.dao.CommentDao;
import com.karat.cn.blog_backstage.dao.TagDao;
import com.karat.cn.blog_backstage.dao.UserDao;
import com.karat.cn.blog_backstage.util.HtmlUtil;
import com.karat.cn.blog_backstage.util.IdUtil;
import com.karat.cn.blog_backstage.util.RedisKey;
import com.karat.cn.blog_backstage.util.TimeUtil;
import com.karat.cn.blog_backstage.vo.BlogResponseVo;
import com.karat.cn.blog_backstage.vo.CommentResponseVo;
import com.karat.cn.blog_backstage.vo.DetailResponseVo;
import com.karat.cn.blog_backstage.vo.UserResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api("接口")
public class KaratController {

    @Autowired
    BlogDao blogDao;
    @Autowired
    TagDao tagDao;
    @Autowired
    CommentDao commentDao;
    @Autowired
    UserDao userDao;


    /**
     * 获取博客列表
     * @param limit
     * @param page
     * @return
     */
    @RequestMapping("getBlogList")
    public BlogResponseVo getBlogList(int limit, int page){
        System.out.println("【当前条数】"+limit+"【当前页数】"+page);
        List<Blog> blogs=blogDao.selectAllByPage(0,-1);
        BlogResponseVo vo=new BlogResponseVo();
        if(blogs.size()>0){
            vo.setCode("200");
            vo.setMsg("请求成功");
            vo.setPage(blogs.size());
            vo.setBlogs(blogs);
        }else{
            vo.setCode("201");
            vo.setMsg("请求失败");
            vo.setPage(0);
            vo.setBlogs(null);
        }
        return vo;
    }

    /**
     * 博客详情
     * @param blogId
     * @return
     */
    @RequestMapping("getBlogDetail")
    public DetailResponseVo getBlogDetail(String blogId){
        System.out.println("【博客主键】"+blogId);
        DetailResponseVo vo=new DetailResponseVo();
        Blog blog=blogDao.selectById(blogId);
        if(blog!=null){
            vo.setCode("200");
            vo.setMsg("请求成功");
            vo.setSlug(HtmlUtil.getHtmlString());
            vo.setBlog(blog);
        }else{
            vo.setCode("201");
            vo.setMsg("请求失败");
            vo.setSlug("");
            vo.setBlog(null);
        }
        return vo;
    }

    /**
     * 根据标签获取列表
     * @param limit
     * @param page
     * @param filter
     * @return
     */
    @RequestMapping("getBlogListByTab")
    public BlogResponseVo getBlogListByTab(int limit,int page,String filter){
        System.out.println("【当前条数】"+limit+"【当前页数】"+page+"【filter】"+filter);
        List<Blog> list=new ArrayList<>();
        switch (filter) {
            case RedisKey.JAVA:
                List<String> listJava=tagDao.selectByTag(RedisKey.JAVA);
                if(listJava.size()>0){
                    listJava.forEach(i->{list.add(blogDao.selectById(i));});
                }
                break;
            case RedisKey.WEB:
                List<String> listWeb=tagDao.selectByTag(RedisKey.WEB);
                if(listWeb.size()>0){
                    listWeb.forEach(i->{list.add(blogDao.selectById(i));});
                }
                break;
            case RedisKey.PYTHON:
                List<String> listPython=tagDao.selectByTag(RedisKey.PYTHON);
                if(listPython.size()>0){
                    listPython.forEach(i->{list.add(blogDao.selectById(i));});
                }
                break;
            case RedisKey.OTHER:
                List<String> listOther=tagDao.selectByTag(RedisKey.OTHER);
                if(listOther.size()>0){
                    listOther.forEach(i->{list.add(blogDao.selectById(i));});
                }
                break;
            default:
                List<String> listHot=tagDao.selectByTag(RedisKey.HOT);
                if(listHot.size()>0){
                    listHot.forEach(i->{list.add(blogDao.selectById(i));});
                }
        }
        return new BlogResponseVo("","",list.size(),list);
    }


    /**
     * 添加评论
     * @param blogId
     * @param userId
     * @param content
     * @return
     */
    @RequestMapping("addComment")
    public CommentResponseVo addComment(String blogId, String userId, String content){
        System.out.println("【博客ID】"+blogId+"【用户ID】"+userId+"【内容】"+content);
        User user=userDao.selectById(userId);
        if(user!=null){
            commentDao.addComment(new Comment(IdUtil.getOrderIdByTime(),user.getUrl(),user.getName(),content, TimeUtil.formateDbDate(TimeUtil.systemtime()),blogId));
            return new CommentResponseVo("200","请求成功");
        }else{
            return new CommentResponseVo("201","请求失败");
        }
    }

    /**
     * 根据博客ID获取评论
     * @param blogId
     * @return
     */
    @RequestMapping("getCommentByBlog")
    public CommentResponseVo getCommentByBlog(String blogId){
        CommentResponseVo vo=new CommentResponseVo();
        System.out.println("【评论ID】"+blogId);
        List<Comment> list=commentDao.selectById(blogId);
       if(list.size()>0){
           return new CommentResponseVo("200","请求成功",list.size(),list);
       }else{
           return new CommentResponseVo("201","请求失败",0,null);
       }
    }


    /**
     * 添加用户信息
     * @param user
     */
    @RequestMapping("addUser")
    public UserResponseVo addUser(User user){
        System.out.println("【用户信息】"+user.toString());
        userDao.addUser(user);
        return new UserResponseVo("200","请求成功",null);
    }

    /**
     * 根据openId获取用户信息
     * @param openId
     * @return
     */
    @RequestMapping("getUserByOpenId")
    public UserResponseVo getUserByOpenId(String openId){
        System.out.println("【openId】"+openId);
        User user=userDao.selectById(openId);
        if(user!=null){
            return new UserResponseVo("200","请求成功",user);
        }else{
            return new UserResponseVo("201","请求失败",null);
        }
    }


}
