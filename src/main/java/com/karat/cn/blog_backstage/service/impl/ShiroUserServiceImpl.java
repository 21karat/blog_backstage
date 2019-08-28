package com.karat.cn.blog_backstage.service.impl;

import com.karat.cn.blog_backstage.bean.pojo.Role_permission;
import com.karat.cn.blog_backstage.bean.pojo.ShiroRole;
import com.karat.cn.blog_backstage.bean.pojo.ShiroUser;
import com.karat.cn.blog_backstage.bean.pojo.User_role;
import com.karat.cn.blog_backstage.service.*;
import com.karat.cn.blog_backstage.service.reposition.RolePermissionReposition;
import com.karat.cn.blog_backstage.service.reposition.ShiroUserReposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class ShiroUserServiceImpl implements ShiroUserService {


    @Autowired
    ShiroUserReposition shiroUserReposition;
    @Autowired
    ShiroUserService shiroUserService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    ShiroRoleService shiroRoleService;
    @Autowired
    RolePermissionService rolePermissionService;
    @Autowired
    PermissionService permissionService;
    /**
     * 创建用户
     * @param user
     */
    public ShiroUser createShiroUser(ShiroUser user){
        return shiroUserReposition.save(user);
    }

    /**
     * 修改密码
     * @param id
     * @param newPassword
     */
    public void changePassword(int id, String newPassword){
        ShiroUser shiroUser=shiroUserService.getShiroUser(id);
        if(shiroUser!=null){
            shiroUser.setPassword(newPassword);
            shiroUserReposition.save(shiroUser);
        }
    }
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public ShiroUser findByUsername(String username){
        return shiroUserReposition.getShiroUserByUsername(username);
    }

    /**
     * 根据用户名查看当前用户角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username){
        Set<String> roles=new HashSet<String>();
        //根据用户名查用户
        ShiroUser u=shiroUserService.findByUsername(username);
        List<User_role> user_roles=userRoleService.select(u.getId());
        //将拿到的角色遍历
        for(User_role ur:user_roles){
            ShiroRole r=shiroRoleService.getShiroRoleById(ur.getRoleId());
            //将角色名放入set集合中
            roles.add(r.getRole());
        }
        return roles;
    }

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username){
        Set<String> permissions=new HashSet<String>();
        //根据用户名查用户信息
        //根据用户名查用户
        ShiroUser u=shiroUserService.findByUsername(username);
        List<User_role> user_roles=userRoleService.select(u.getId());
        //将拿到的角色遍历
        for(User_role ur:user_roles){
            ShiroRole r=shiroRoleService.getShiroRoleById(ur.getRoleId());
            List <Role_permission> rps=rolePermissionService.select(r.getRoleid());
            //将拿到的角色权限关联表信息遍历，拿到权限信息添加到set中
            for(Role_permission rp:rps){
                String permission=permissionService.getPermissionByid(rp.getPermissionId()).getPermission();
                permissions.add(permission);
            }
        }
        return permissions;
    }

    /**
     * 查看所有用户
     * @return
     */
    public List<ShiroUser> getAllShiroUser(){
        return shiroUserReposition.findAll();
    }

    /**
     * 分页查所有用户
     * @param pagenum
     * @param pagesize
     * @return
     */
    public List<ShiroUser> getPageShiroUser(int pagenum, int pagesize){
        return null;
    }
    /**
     * 更新用户信息
     * @param u
     * @return
     */
    public ShiroUser updateShiroUser(ShiroUser u){
        return shiroUserReposition.save(u);
    }

    /**
     * 删除用户信息
     * @param id
     */
    public void deleteShiroUser(int id){
        shiroUserReposition.deleteById(id);
    }
    /**
     * 根据id查
     * @param id
     * @return
     */
    public ShiroUser getShiroUser(int id){
        return shiroUserReposition.findById(id);
    }

}
