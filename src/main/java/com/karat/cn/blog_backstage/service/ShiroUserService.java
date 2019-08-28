package com.karat.cn.blog_backstage.service;


import com.karat.cn.blog_backstage.bean.pojo.ShiroUser;

import java.util.List;
import java.util.Set;

public interface ShiroUserService {

    /**
     * 创建用户
     * @param user
     */
    ShiroUser createShiroUser(ShiroUser user);

    /**
     * 修改密码
     * @param id
     * @param newPassword
     */
    void changePassword(int id, String newPassword);
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    ShiroUser findByUsername(String username);
    
    /**
     * 根据用户名查看当前用户角色
     * @param username
     * @return
     */
    Set<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    Set<String> findPermissions(String username);
    
    /**
     * 查看所有用户
     * @return
     */
    List<ShiroUser> getAllShiroUser();
    
    /**
     * 分页查所有用户
     * @param pagenum
     * @param pagesize
     * @return
     */
    List<ShiroUser> getPageShiroUser(int pagenum, int pagesize);
    /**
     * 更新用户信息
     * @param u
     * @return
     */
    ShiroUser updateShiroUser(ShiroUser u);
    /**
     * 删除用户信息
     * @param id
     */
    void deleteShiroUser(int id);
    /**
     * 根据id查
     * @param id
     * @return
     */
	ShiroUser getShiroUser(int id);

}
