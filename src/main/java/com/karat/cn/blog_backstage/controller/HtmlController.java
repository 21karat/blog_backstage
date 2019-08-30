package com.karat.cn.blog_backstage.controller;


import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("html")
@Api("html页面跳转")
public class HtmlController {


    @RequestMapping(value = "/toTag", method = {RequestMethod.POST, RequestMethod.GET})
    public String toTag() {
        return "tag/tag-list";
    }
    @RequestMapping(value = "/toMember", method = {RequestMethod.POST, RequestMethod.GET})
    public String toMember() {
        return "member/member-list";
    }
    @RequestMapping(value = "/toFriend", method = {RequestMethod.POST, RequestMethod.GET})
    public String toFriend() {
        return "friend/friend-list";
    }
    @RequestMapping(value = "/toAuthor", method = {RequestMethod.POST, RequestMethod.GET})
    public String toAuthor() {
        return "author/author-list";
    }



    @RequestMapping(value = "/toShiroUser", method = {RequestMethod.POST, RequestMethod.GET})
    public String toShiroUser() {
        return "admin/admin-list";
    }
    @RequestMapping(value = "/toShiroRole", method = {RequestMethod.POST, RequestMethod.GET})
    public String toShiroRole() {
        return "admin/admin-role";
    }
    @RequestMapping(value = "/toShiroRule", method = {RequestMethod.POST, RequestMethod.GET})
    public String toShiroRule() {
        return "admin/admin-rule";
    }
    @RequestMapping(value = "/toCate", method = {RequestMethod.POST, RequestMethod.GET})
    public String toCate() {
        return "admin/admin-cate";
    }

    @RequestMapping(value = "/toWelcome", method = {RequestMethod.POST, RequestMethod.GET})
    public String toWelcome() {
        return "welcome/welcome";
    }
    @RequestMapping(value = "/toWelcome1", method = {RequestMethod.POST, RequestMethod.GET})
    public String toWelcome1() {
        return "welcome/welcome1";
    }
    @RequestMapping(value = "/toError", method = {RequestMethod.POST, RequestMethod.GET})
    public String toError() {
        return "error/error";
    }
    @RequestMapping(value = "/toLog", method = {RequestMethod.POST, RequestMethod.GET})
    public String toLog() {
        return "error/log";
    }


    @RequestMapping(value = "/toOrder", method = {RequestMethod.POST, RequestMethod.GET})
    public String toOrder() {
        return "order/order-list";
    }
    @RequestMapping(value = "/toOrder1", method = {RequestMethod.POST, RequestMethod.GET})
    public String toOrder1() {
        return "order/order-list1";
    }
    @RequestMapping(value = "/toMemberDel", method = {RequestMethod.POST, RequestMethod.GET})
    public String toMemberDel() {
        return "member/member-del";
    }


    @RequestMapping(value = "/toIndex", method = {RequestMethod.POST, RequestMethod.GET})
    public String toIndex() {
        return "index";
    }

}
