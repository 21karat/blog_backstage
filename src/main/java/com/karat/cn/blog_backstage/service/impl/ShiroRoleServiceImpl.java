package com.karat.cn.blog_backstage.service.impl;


import com.karat.cn.blog_backstage.bean.pojo.ShiroRole;
import com.karat.cn.blog_backstage.service.ShiroRoleService;
import com.karat.cn.blog_backstage.service.reposition.ShiroRoleReposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ShiroRoleServiceImpl implements ShiroRoleService {

	@Autowired
	ShiroRoleReposition shiroRoleReposition;

	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	public ShiroRole createShiroRole(ShiroRole role){
		return shiroRoleReposition.save(role);
	}
	/**
	 * 删除角色
	 * @param roleid
	 */
	public void deleteShiroRole(int roleid){shiroRoleReposition.deleteById(roleid);}
	/**
	 * 更新角色
	 * @param r
	 * @return
	 */
	public ShiroRole updateShiroRole(ShiroRole r){
		return shiroRoleReposition.save(r);
	}

	/**
	 * 查看所有角色
	 * @return
	 */
	public List<ShiroRole> getShiroRoles(){
		return shiroRoleReposition.findAll();
	}

	/**
	 * 分页查所有角色
	 * @param pagenum
	 * @param pagesize
	 * @return
	 */
	public List<ShiroRole> getPageShiroRole(int pagenum, int pagesize){
		return new ArrayList<>();
	}
	/**
	 * 根据角色id查看角色
	 * @param roleid
	 * @return
	 */
	public ShiroRole getShiroRoleById(int roleid){
		return shiroRoleReposition.findById(roleid);
	}

}
