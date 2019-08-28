package com.karat.cn.blog_backstage.service.reposition;

import com.karat.cn.blog_backstage.bean.pojo.User_role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleReposition extends JpaRepository<User_role,Integer> {

      List<User_role> findAllByUserId(int userid);
}
