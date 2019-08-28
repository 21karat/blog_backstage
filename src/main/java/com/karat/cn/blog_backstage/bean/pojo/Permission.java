package com.karat.cn.blog_backstage.bean.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 后台权限表
 * @author 开发
 *
 */
@Entity
@Table(name="sys_permissions")
public class Permission {

	//权限表自增ID
	@Id
	int permissionid;
	//权限名称
	@Column(name="permission")
	String permission;
	//权限描述
	@Column(name="description")
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
