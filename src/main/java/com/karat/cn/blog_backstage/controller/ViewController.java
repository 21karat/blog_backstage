package com.karat.cn.blog_backstage.controller;

import com.alibaba.fastjson.JSONObject;
import com.karat.cn.blog_backstage.bean.User;
import com.karat.cn.blog_backstage.dao.UserDao;
import com.karat.cn.blog_backstage.util.PageUtil;
import com.karat.cn.blog_backstage.vo.view.ResponseUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/back")
public class ViewController {


    @Autowired
    private UserDao userDao;

    @RequestMapping("/login")
    @CrossOrigin
    public String login(String username,String password)  {
        System.out.println(username+password);
        return JSONObject.toJSONString("123456");
    }

    @RequestMapping("/getUser")
    @CrossOrigin
    public ResponseUserVo getUser(int limit,int curr)  {
        System.out.println("每页大小："+limit+"当前页:"+curr);
        List<User> users=userDao.selectAll();
        return new ResponseUserVo(users.size(),curr,PageUtil.getPageByList(users,curr,limit));
    }

    @RequestMapping("/addUser")
    @CrossOrigin
    public ResponseUserVo addUser(User user)  {
        System.out.println(user.toString());
        userDao.addUser(user);
        List<User> users=userDao.selectAll();
        return new ResponseUserVo(users.size(),1,PageUtil.getPageByList(users,1,2));
    }

}