package com.karat.cn.blog_backstage.controller;

import com.karat.cn.blog_backstage.bean.*;
import com.karat.cn.blog_backstage.dao.*;
import com.karat.cn.blog_backstage.util.*;
import com.karat.cn.blog_backstage.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

import java.util.ArrayList;
import java.util.List;

import weixin.popular.api.SnsAPI;
import weixin.popular.bean.sns.Jscode2sessionResult;

@RestController
@Api("小程序Api接口")
public class KaratController {

    @Autowired
    BlogDao blogDao;
    @Autowired
    TagDao tagDao;
    @Autowired
    CommentDao commentDao;
    @Autowired
    UserDao userDao;
    @Autowired
    FriendDao friendDao;
    @Autowired
    AuthorDao authorDao;

    /**
     * 获取博客列表
     * @param limit
     * @param page
     * @return
     */
    @PostMapping("getBlogList")
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
    @PostMapping("getBlogDetail")
    public DetailResponseVo getBlogDetail(String blogId){
        System.out.println("【博客主键】"+blogId);
        DetailResponseVo vo=new DetailResponseVo();
        Blog blog=blogDao.selectById(blogId);
        if(blog!=null){
            vo.setCode("200");
            vo.setMsg("请求成功");
            vo.setSlug(blogDao.selectHtml(blog.getId()));
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
    @PostMapping("getBlogListByTab")
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
     * @param openId
     * @param content
     * @return
     */
    @PostMapping("addComment")
    public CommentResponseVo addComment(String blogId, String openId, String content){
        System.out.println("【博客ID】"+blogId+"【用户openId】"+openId+"【内容】"+content);
        User user=userDao.selectById(openId);
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
    @PostMapping("getCommentByBlog")
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
     * 获取openId
     * @param code
     * @return
     */
    @PostMapping("getOpenId")
    public WxResponseVo getOpenId(String code){
        WxResponseVo vo=new WxResponseVo("201","请求失败","");
        String appid="wxd7c8e803703c3868"; String secret="bf286bf21e998d272f5319db1a2dd9b0";
        //1,获取凭证信息
        Jscode2sessionResult token = SnsAPI.jscode2session(appid, secret,code);
        if(!token.getOpenid().equals("")){
            System.out.println("【OPENID】"+token.getOpenid());
            vo.setCode("200");
            vo.setMsg("请求成功");
            vo.setOpenid(token.getOpenid());
        }
        return vo;
    }
    /**
     * 添加用户信息
     * @param userRequestVo
     * @return
     */
    @PostMapping("addUser")
    public UserResponseVo addUser(UserRequestVo userRequestVo){
        System.out.println("【请求信息】"+userRequestVo.toString());
        UserResponseVo vo=new UserResponseVo("200","请求成功",null);
        String appid="wxd7c8e803703c3868"; String secret="bf286bf21e998d272f5319db1a2dd9b0"; String code=userRequestVo.getCode();
        //1,获取凭证信息
        Jscode2sessionResult token = SnsAPI.jscode2session(appid, secret,code);
        if(!token.getOpenid().equals("")){
            System.out.println("【OPENID】"+token.getOpenid());
            User user=userDao.selectById(token.getOpenid());
            if(user!=null){
                vo.setUser(user);
            }else{
                userDao.addUser(new User(IdUtil.getOrderIdByTime(),token.getOpenid(),userRequestVo.getAvatarUrl(),userRequestVo.getNickName()));
                vo.setUser(userDao.selectById(token.getOpenid()));
            }
        }
        return vo;
    }
    /**
     * 根据openId获取用户信息
     * @param openId
     * @return
     */
    @PostMapping("getUserByOpenId")
    public UserResponseVo getUserByOpenId(String openId){
        System.out.println("【openId】"+openId);
        User user=userDao.selectById(openId);
        if(user!=null){
            return new UserResponseVo("200","请求成功",user);
        }else{
            return new UserResponseVo("201","请求失败",null);
        }
    }
    /**
     * 查看友链
     * @return
     */
    @PostMapping("getFrends")
    public List<Friend> getFrends(){
        return friendDao.selectAll();
    }
    /**。
     * 联系我
     * @return
     */
    @PostMapping("selectAuthor")
    public Author selectAuthor(){
        return authorDao.select();
    }
}
