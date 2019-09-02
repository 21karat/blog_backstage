package com.karat.cn.blog_backstage.controller;

import com.karat.cn.blog_backstage.bean.Author;
import com.karat.cn.blog_backstage.bean.Friend;
import com.karat.cn.blog_backstage.bean.User;
import com.karat.cn.blog_backstage.dao.*;
import com.karat.cn.blog_backstage.service.PermissionService;
import com.karat.cn.blog_backstage.service.RolePermissionService;
import com.karat.cn.blog_backstage.service.ShiroRoleService;
import com.karat.cn.blog_backstage.service.ShiroUserService;
import com.karat.cn.blog_backstage.util.PageUtil;
import com.karat.cn.blog_backstage.util.RedisKey;
import com.karat.cn.blog_backstage.vo.shiro.PermissionVo;
import com.karat.cn.blog_backstage.vo.shiro.RoleVo;
import com.karat.cn.blog_backstage.vo.shiro.ShiroRoleVo;
import com.karat.cn.blog_backstage.vo.shiro.ShiroUserVo;
import com.karat.cn.blog_backstage.vo.view.ResponseNumVo;
import com.karat.cn.blog_backstage.vo.view.ResponseTagVo;
import com.karat.cn.blog_backstage.vo.view.ResponseUserVo;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 *  属于user角色@RequiresRoles("user")
 * 	必须同时属于user和admin角@RequiresRoles({ "user", "admin" })
 * 	属于user或者admin之一;修改logical为OR 即可@RequiresRoles(value = { "user", "admin"},
 * 	logical = Logical.OR)
 */
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
    @Autowired
    RolePermissionService rolePermissionService;


    // 登录的url
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
    public String login(String username, String password, Map<String, Object> map) {
        System.out.println("登陆开始");
        //将用户名与密码存入令牌中
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        String msg = "";
        try {
            Subject subject = SecurityUtils.getSubject();
            //将用户名密码生成的token令牌传入login方法中
            subject.login(token);
            return "redirect:/html/toIndex";
        } catch (IncorrectCredentialsException e) {
            msg = "登录密码错误";
            System.out.println("登录密码错误!!!" + e);
        } catch (ExcessiveAttemptsException e) {
            msg = "登录失败次数过多";
            System.out.println("登录失败次数过多!!!" + e);
        } catch (LockedAccountException e) {
            msg = "帐号已被锁定";
            System.out.println("帐号已被锁定!!!" + e);
        } catch (DisabledAccountException e) {
            msg = "帐号已被禁用";
            System.out.println("帐号已被禁用!!!" + e);
        } catch (ExpiredCredentialsException e) {
            msg = "帐号已过期";
            System.out.println("帐号已过期!!!" + e);
        } catch (UnknownAccountException e) {
            msg = "帐号不存在";
            System.out.println("帐号不存在!!!" + e);
        } catch (UnauthorizedException e) {
            msg = "您没有得到相应的授权！";
            System.out.println("您没有得到相应的授权！" + e);
        } catch (Exception e) {
            System.out.println("出错！！！" + e);
        }
        map.put("msg", msg);
        return "login";
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
        List<RoleVo> shiroRoles=new ArrayList<>();
        shiroRoleService.getShiroRoles().forEach(i->{
            RoleVo vo=new RoleVo();
            vo.setRoleid(i.getRoleid());
            vo.setRole(i.getRole());
            vo.setDescription(i.getDescription());

            Set set=new HashSet();
            rolePermissionService.select(i.getRoleid()).forEach(j->{
                vo.setRoledes(vo.getRoledes()+"【"+permissionService.getPermissionByid(j.getPermissionId()).getPermission()+"】");
            });
            shiroRoles.add(vo);
        });
        return new ShiroRoleVo(200,"ok",shiroRoles);
    }

    @RequestMapping("selectPermission")
    @ResponseBody
    @RequiresPermissions("user:select")//权限管理;
    public PermissionVo selectPermission(){
        return new PermissionVo(200,"ok",permissionService.getPermissions());
    }

















}