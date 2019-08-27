package com.karat.cn.blog_backstage.bean.pojo;

/**
 * 用户角色绑定表
 */
public class User_role {

	//自增ID
	int id;
	//用户（用户ID）
	int userId;
	//角色（角色ID）
	int roleId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
