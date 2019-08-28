package com.karat.cn.blog_backstage.bean;


import com.karat.cn.blog_backstage.service.ShiroUserService;
import com.karat.cn.blog_backstage.service.UserRoleService;
import com.karat.cn.blog_backstage.service.reposition.UserRoleReposition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroUserTest {


    @Autowired
    ShiroUserService shiroUserService;
    @Autowired
    UserRoleService userRoleService;

    @Autowired
    UserRoleReposition userRoleReposition;

    @Test
    public void select(){
        System.out.println(shiroUserService.getAllShiroUser());
    }

    @Test
    public void selectByName(){
        System.out.println(shiroUserService.findByUsername("ddd"));
    }

    @Test
    public void selectRole(){
        System.out.println(shiroUserService.findRoles("TOM").toString());
    }

    @Test
    public void selectUser_role(){
        userRoleService.select(12).forEach(i->{
            System.out.println(i.toString());
        });
        userRoleReposition.findAllByUserId(7).forEach(i->{
            System.out.println(i.toString());
        });
    }
}
