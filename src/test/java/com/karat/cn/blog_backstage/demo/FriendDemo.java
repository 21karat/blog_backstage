package com.karat.cn.blog_backstage.demo;

import com.karat.cn.blog_backstage.bean.Friend;
import com.karat.cn.blog_backstage.dao.FriendDao;
import com.karat.cn.blog_backstage.util.IdUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FriendDemo {

    @Autowired
    FriendDao friendDao;

    @Test
    public void add(){
        //Friend friend=new Friend(IdUtil.getOrderIdByTime(),"罗凯","www.luokaiii.cn");
        Friend friend=new Friend(IdUtil.getOrderIdByTime(),"墨尔本科","https://me.csdn.net/weixin_39554569");
        friendDao.add(friend);
    }

    @Test
    public void select(){
        List<Friend> list= friendDao.selectAll();
        if(list.size()>0){
            list.forEach(i->{
                System.out.println(i.toString());
            });
        }else{
            System.out.println("【null】");
        }
    }

}
