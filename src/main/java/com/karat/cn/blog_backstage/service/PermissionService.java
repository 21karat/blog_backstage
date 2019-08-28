package com.karat.cn.blog_backstage.service;

import com.karat.cn.blog_backstage.bean.pojo.Permission;

import java.util.List;


public interface PermissionService {

	/**
	 * 添加权限
	 * @param permission
	 * @return
	 */
    Permission createPermission(Permission permission);
    /**
	 * 根据权限表id删除权限信息
	 */
    void deletePermission(int permissionId);
    /**
     * 更新
     * @param permission
     * @return
     */
    Permission updatePermission(Permission permission);



    /**
     * 查所有
     * @return
     */
    List<Permission> getPermissions();
    /**
     * 根据权限表id查所有
     * @param permissionid
     * @return
     */
    Permission getPermissionByid(int permissionid);
    /**
     * 分页查
     * @param pagenum
     * @param pagesize
     * @return
     */
    List<Permission> getPagePermissions(int pagenum, int pagesize);
}
