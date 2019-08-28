package com.karat.cn.blog_backstage.service.reposition;

import com.karat.cn.blog_backstage.bean.pojo.ShiroUser;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface  ShiroUserReposition extends JpaRepository<ShiroUser,Integer>{

    //根据用户名查看
    ShiroUser getShiroUserByUsername(String username);
    //根据ID查看
    ShiroUser findById(int id);

}
