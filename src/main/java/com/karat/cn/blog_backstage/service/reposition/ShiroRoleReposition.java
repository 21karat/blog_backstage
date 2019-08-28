package com.karat.cn.blog_backstage.service.reposition;

import com.karat.cn.blog_backstage.bean.pojo.ShiroRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiroRoleReposition extends JpaRepository<ShiroRole,Integer> {

    //根据ID查看
    ShiroRole findById(int id);
}
