package com.karat.cn.blog_backstage.service.reposition;

import com.karat.cn.blog_backstage.bean.pojo.Role_permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionReposition extends JpaRepository<Role_permission,Integer> {

    List<Role_permission> findAllByRoleId(int roleId);
}
