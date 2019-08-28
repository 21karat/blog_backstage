package com.karat.cn.blog_backstage.service.reposition;

import com.karat.cn.blog_backstage.bean.pojo.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionReposition extends JpaRepository<Permission,Integer> {
    //根据ID查看
    Permission findById(int id);
}
