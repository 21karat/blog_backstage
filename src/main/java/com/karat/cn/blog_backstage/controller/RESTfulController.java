package com.karat.cn.blog_backstage.controller;

import com.karat.cn.blog_backstage.bean.Author;
import com.karat.cn.blog_backstage.bean.Friend;
import com.karat.cn.blog_backstage.bean.User;
import com.karat.cn.blog_backstage.dao.AuthorDao;
import com.karat.cn.blog_backstage.dao.BlogDao;
import com.karat.cn.blog_backstage.dao.FriendDao;
import com.karat.cn.blog_backstage.dao.UserDao;
import com.karat.cn.blog_backstage.util.PageUtil;
import com.karat.cn.blog_backstage.util.RedisKey;
import com.karat.cn.blog_backstage.vo.view.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("rest")
@Api("RESTful风格的Api接口")
public class RESTfulController {

    private static final Logger log = LoggerFactory.getLogger(RESTfulController.class);


    @Autowired
    AuthorDao authorDao;
    @Autowired
    FriendDao friendDao;
    @Autowired
    UserDao userDao;
    @Autowired
    BlogDao blogDao;
    /*============================================博客小程序数据统计======================================*/
    @PostMapping("/frend")
    @ApiOperation("查看友链")
    public List<Friend> getFrends(){
        return friendDao.selectAll();
    }
    @PostMapping("/author")
    @ApiOperation("查看联系我")
    public Author selectAuthor(){
        return authorDao.select();
    }
    @PostMapping("/tag")
    @ApiOperation("查看标签")
    public List<ResponseTagVo> selectTag(){
        List<ResponseTagVo> vo=new ArrayList<>();
        vo.add(new ResponseTagVo(RedisKey.JAVA));
        vo.add(new ResponseTagVo(RedisKey.HOT));
        vo.add(new ResponseTagVo(RedisKey.PYTHON));
        vo.add(new ResponseTagVo(RedisKey.OTHER));
        vo.add(new ResponseTagVo(RedisKey.WEB));
        return vo;
    }
    @PostMapping("number")
    @ApiOperation("查看数据统计")
    public ResponseNumVo getNum(){
        return new ResponseNumVo(blogDao.selectAll().size(),userDao.selectAll().size(),199, 5,friendDao.selectAll().size());
    }
    /*============================================博客小程序用户信息操作======================================*/

    @PostMapping("/user")
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    public ResponseUserVo insertUser(@RequestBody User user)  {
        log.warn(user.toString());
        userDao.addUser(user);
        List<User> users=userDao.selectAll();
        return new ResponseUserVo(users.size(),1, PageUtil.getPageByList(users,1,2));
    }
    @DeleteMapping("/user/{openId}")
    @ApiOperation(value = "删除操作" ,notes = "根据openId删除")
    @ApiImplicitParam(name = "openId",value = "openId删除",required = true,dataType = "String")
    public ResponseUserVo delUser(@PathVariable String openId)  {
        log.warn("删除openId:"+openId);
        userDao.delUser(openId);
        List<User> users=userDao.selectAll();
        return new ResponseUserVo(users.size(),1,PageUtil.getPageByList(users,1,2));
    }
    @PutMapping("/user/{opid}")
    @ApiOperation(value = "更新操作",notes = "单个更新")
    public Response editUser(@PathVariable String opid,@RequestParam("openId") String openId,@RequestParam("url") String url,@RequestParam("name") String name){
        log.warn("name :"+name+"openId:"+openId+"url:"+url+"opid:"+opid);
        User user=userDao.selectById(opid);
        if(user!=null){
            user.setName(name);
            user.setUrl(url);
            userDao.updateUser(user);
            return new Response(200,"ok");
        }else{
            return new Response(201,"error");
        }
    }
    @GetMapping("/user")
    @ApiOperation("查看用户")
    public ResponseUserVo getUserByPage(@RequestParam int limit,@RequestParam int curr)  {
        log.warn("每页大小："+limit+"当前页:"+curr);
        List<User> users=userDao.selectAll();
        System.out.println(users.size());
        return new ResponseUserVo(users.size(),curr,PageUtil.getPageByList(users,curr,limit));
    }
}
