package com.karat.cn.blog_backstage.vo.view;

import com.karat.cn.blog_backstage.bean.User;

import java.util.List;

public class ResponseUserVo {

    private int count;//总条数

    private int curr;//当前页

    private List<User> users;//数据

    public ResponseUserVo() {
    }

    public ResponseUserVo(int count, int curr, List<User> users) {
        this.count = count;
        this.curr = curr;
        this.users = users;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCurr() {
        return curr;
    }

    public void setCurr(int curr) {
        this.curr = curr;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
