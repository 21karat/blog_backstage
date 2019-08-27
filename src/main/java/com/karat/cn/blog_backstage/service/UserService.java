package com.karat.cn.blog_backstage.service;

import com.karat.cn.blog_backstage.bean.User;
import com.karat.cn.blog_backstage.bean.pojo.ShiroUser;

import java.util.List;
import java.util.Set;

public interface UserService {

    /**
     * 创建用户
     * @param user
     */
    ShiroUser createUser(ShiroUser user);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    void changePassword(int userId, String newPassword);

    /**
     * 添加用户-角色关系
     * @param userId
     * @param roleIds
     */
    void correlationRoles(int userId, int... roleIds);

    /**
     * 移除用户-角色关系
     * @param userId
     * @param roleIds
     */
    void uncorrelationRoles(int userId, int... roleIds);

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
    List<User> getallusers();
    
    /**
     * 分页查所有用户
     * @param pagenum
     * @param pagesize
     * @return
     */
    List<ShiroUser> getpageusers(int pagenum, int pagesize);
    /**
     * 更新用户信息
     * @param u
     * @return
     */
    ShiroUser updateuser(ShiroUser u);
    /**
     * 删除用户信息
     * @param userid
     */
    void deleteuser(int userid);
    /**
     * 根据id查
     * @param uid
     * @return
     */
	ShiroUser getUser(int uid);
	/**
	 * 删除用户角色关系信息
	 * @param uid
	 */
	void deleteuserroles(int uid);
}
