package com.karat.cn.blog_backstage.service;

import com.karat.cn.blog_backstage.bean.pojo.ShiroRole;

import java.util.List;


public interface ShiroRoleService {

	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
    ShiroRole createShiroRole(ShiroRole role);
    /**
     * 删除角色
     * @param roleid
     */
    void deleteShiroRole(int roleid);
    /**
     * 更新角色
     * @param r
     * @return
     */
     ShiroRole updateShiroRole(ShiroRole r);

    /**
     * 查看所有角色
     * @return
     */
    List<ShiroRole> getShiroRoles();
    /**
     * 分页查所有角色
     * @param pagenum
     * @param pagesize
     * @return
     */
    List<ShiroRole> getPageShiroRole(int pagenum, int pagesize);

    /**
     * 根据角色id查看角色
     * @param roleid
     * @return
     */
    ShiroRole getShiroRoleById(int roleid);
}
