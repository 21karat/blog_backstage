package com.karat.cn.blog_backstage.service.impl;


import com.karat.cn.blog_backstage.bean.pojo.Permission;
import com.karat.cn.blog_backstage.service.PermissionService;
import com.karat.cn.blog_backstage.service.reposition.PermissionReposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	PermissionReposition permissionReposition;

	/**
	 * 添加权限
	 */
	public Permission createPermission(Permission permission) {
		return permissionReposition.save(permission);
	}
	/**
	 * 根据权限表id删除权限信息
	 */
	public void deletePermission(int permissionId) {
		permissionReposition.deleteById(permissionId);
	}
	/**
	 * 更新
	 */
	public Permission updatePermission(Permission permission) {
		return permissionReposition.save(permission);
	}


	/**
	 * 查所有
	 */
	public List<Permission> getPermissions() {
		return permissionReposition.findAll();
	}
	/**
	 * 根据权限表id查所有
	 */
	public Permission getPermissionByid(int permissionid) {
		return permissionReposition.findById(permissionid);
	}
	/**
	 * 分页查
	 */
	public List<Permission> getPagePermissions(int pagenum, int pagesize) {
		return null;
	}


}
