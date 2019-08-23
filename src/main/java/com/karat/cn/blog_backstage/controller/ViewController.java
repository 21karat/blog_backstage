package com.karat.cn.blog_backstage.controller;

import com.alibaba.fastjson.JSONObject;
import com.karat.cn.blog_backstage.bean.Author;
import com.karat.cn.blog_backstage.bean.Friend;
import com.karat.cn.blog_backstage.bean.User;
import com.karat.cn.blog_backstage.dao.*;
import com.karat.cn.blog_backstage.util.PageUtil;
import com.karat.cn.blog_backstage.util.RedisKey;
import com.karat.cn.blog_backstage.vo.view.ResponseTagVo;
import com.karat.cn.blog_backstage.vo.view.ResponseUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("view")
public class ViewController {


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


    @RequestMapping("/login")
    @ResponseBody
    public String lo(String username,String password)  {
        System.out.println(username+password);
        return JSONObject.toJSONString("123456");
    }

    @RequestMapping("/getUserByPage")
    @ResponseBody
    public ResponseUserVo getUserByPage(int limit,int curr)  {
        System.out.println("每页大小："+limit+"当前页:"+curr);
        List<User> users=userDao.selectAll();
        System.out.println(users.size());
        return new ResponseUserVo(users.size(),curr,PageUtil.getPageByList(users,curr,limit));
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public ResponseUserVo insertUser(User user)  {
        System.out.println(user.toString());
        userDao.addUser(user);
        List<User> users=userDao.selectAll();
        return new ResponseUserVo(users.size(),1,PageUtil.getPageByList(users,1,2));
    }

    @RequestMapping("/delUser")
    @ResponseBody
    public ResponseUserVo delUser(String openId)  {
        userDao.delUser(openId);
        List<User> users=userDao.selectAll();
        return new ResponseUserVo(users.size(),1,PageUtil.getPageByList(users,1,2));
    }


    /**
     * 查看友链
     * @return
     */
    @RequestMapping("getFrends")
    @ResponseBody
    public List<Friend> getFrends(){
        return friendDao.selectAll();
    }


    /**
     * 联系我
     * @return
     */
    @RequestMapping("selectAuthor")
    @ResponseBody
    public Author selectAuthor(){
        return authorDao.select();
    }

    /**
     * 标签
     * @return
     */
    @RequestMapping("selectTag")
    @ResponseBody
    public List<ResponseTagVo> selectTag(){
        List<ResponseTagVo> vo=new ArrayList<>();
        vo.add(new ResponseTagVo(RedisKey.JAVA));
        vo.add(new ResponseTagVo(RedisKey.HOT));
        vo.add(new ResponseTagVo(RedisKey.PYTHON));
        vo.add(new ResponseTagVo(RedisKey.OTHER));
        vo.add(new ResponseTagVo(RedisKey.WEB));
        return vo;
    }

}