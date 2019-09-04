package com.karat.cn.blog_backstage.config;

import com.karat.cn.blog_backstage.vo.shiro.ShiroResponseVo;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常捕捉类
 *
 * @author Bean
 *
 */
@ControllerAdvice
public class AllException {


    /// 角色权限限异常捕捉
    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public ShiroResponseVo roleException(UnauthorizedException e) {
        System.out.println("---------角色权限限异常捕捉------------->" + e);
        return new ShiroResponseVo(201,"角色权限不够");
    }


    // 其它异常异常捕捉
    @ExceptionHandler(value = Exception.class)
    @ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public String allException(Exception e) {
        System.out.println("----------其它异常异常捕捉------------>" + e);
        return "系統出现异常！！！";
    }

}
