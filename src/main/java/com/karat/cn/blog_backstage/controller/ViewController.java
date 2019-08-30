package com.karat.cn.blog_backstage.controller;

import com.karat.cn.blog_backstage.bean.Author;
import com.karat.cn.blog_backstage.bean.Friend;
import com.karat.cn.blog_backstage.bean.User;
import com.karat.cn.blog_backstage.dao.*;
import com.karat.cn.blog_backstage.service.PermissionService;
import com.karat.cn.blog_backstage.service.ShiroRoleService;
import com.karat.cn.blog_backstage.service.ShiroUserService;
import com.karat.cn.blog_backstage.util.PageUtil;
import com.karat.cn.blog_backstage.util.RedisKey;
import com.karat.cn.blog_backstage.vo.shiro.PermissionVo;
import com.karat.cn.blog_backstage.vo.shiro.ShiroRoleVo;
import com.karat.cn.blog_backstage.vo.shiro.ShiroUserVo;
import com.karat.cn.blog_backstage.vo.view.ResponseLogin;
import com.karat.cn.blog_backstage.vo.view.ResponseNumVo;
import com.karat.cn.blog_backstage.vo.view.ResponseTagVo;
import com.karat.cn.blog_backstage.vo.view.ResponseUserVo;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/view")
@Api("后台接口")
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

    /*=============================================*/
    @Autowired
    ShiroUserService shiroUserService;
    @Autowired
    ShiroRoleService shiroRoleService;
    @Autowired
    PermissionService permissionService;
    /*=============================================*/

    @RequestMapping("/ok")
    public String ok()  {
        return "login";
    }

    /**
     * 后台登陆
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public String login(String username, String password)  {
        System.out.println("登陆开始");
        //将用户名与密码存入令牌中
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            Subject subject = SecurityUtils.getSubject();
            //将用户名密码生成的token令牌传入login方法中
            subject.login(token);
            ResponseLogin msg=new ResponseLogin("login success");
            return "redirect:/html/toIndex";
        } catch ( UnknownAccountException uae ) {
            ResponseLogin msg=new ResponseLogin("error username");
            return "redirect:/html/toError";
        } catch ( IncorrectCredentialsException ice ) {
            ResponseLogin msg=new ResponseLogin("error password");
            return "redirect:/html/toError";
        } catch ( LockedAccountException lae ) {
            ResponseLogin msg=new ResponseLogin("locked user");
            return "redirect:/html/toError";
        }
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping(value="logout",method = {RequestMethod.POST, RequestMethod.GET})
    public String logout(){
        //subject的实现类DelegatingSubject的logout方法，将本subject对象的session清空了
        //即使session托管给了redis ，redis有很多个浏览器的session
        //只要调用退出方法，此subject的、此浏览器的session就没了
        try {
            //退出
            SecurityUtils.getSubject().logout();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return "login";

    }
    /*==================================================================================*/

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
    @RequiresPermissions("user:select")//权限管理;
    public List<Friend> getFrends(){
        return friendDao.selectAll();
    }


    /**
     * 联系我
     * @return
     */
    @RequestMapping("selectAuthor")
    @ResponseBody
    @RequiresPermissions("user:select")//权限管理;
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

    /**
     * 数据统计
     * @return
     */
    @RequestMapping("getNum")
    @ResponseBody
    public ResponseNumVo getNum(){
        return new ResponseNumVo(blogDao.selectAll().size(),userDao.selectAll().size(),199, 5,friendDao.selectAll().size());
    }

    /*=======================================权限===========================================*/


    @RequestMapping("selectShiroUser")
    @ResponseBody
    @RequiresPermissions("user:select")//权限管理;
    public ShiroUserVo selectShiroUser(){
        return new ShiroUserVo(200,"ok",shiroUserService.getAllShiroUser());
    }

    @RequestMapping("selectShiroRole")
    @ResponseBody
    @RequiresPermissions("user:select")//权限管理;
    public ShiroRoleVo selectShiroRole(){
        return new ShiroRoleVo(200,"ok",shiroRoleService.getShiroRoles());
    }

    @RequestMapping("selectPermission")
    @ResponseBody
    @RequiresPermissions("user:select")//权限管理;
    public PermissionVo selectPermission(){
        return new PermissionVo(200,"ok",permissionService.getPermissions());
    }

















}