package com.karat.cn.blog_backstage.bean.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户角色绑定表
 */
@Entity
@Table(name="sys_users_roles")
public class User_role {

	@Id
	int id;
	//用户（用户ID）
	@Column(name="user_id")
	int userId;
	//角色（角色ID）
	@Column(name="role_id")
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

	@Override
	public String toString() {
		return "User_role{" +
				"id=" + id +
				", userId=" + userId +
				", roleId=" + roleId +
				'}';
	}
}
