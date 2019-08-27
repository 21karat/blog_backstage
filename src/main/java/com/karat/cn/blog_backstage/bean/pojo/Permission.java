package com.karat.cn.blog_backstage.bean.pojo;

/**
 * 后台权限表
 * @author 开发
 *
 */
public class Permission {

	//权限表自增ID
	int permissionid;
	//权限名称
	String permission;
	//权限描述
	String description;

	public int getPermissionid() {
		return permissionid;
	}

	public void setPermissionid(int permissionid) {
		this.permissionid = permissionid;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
