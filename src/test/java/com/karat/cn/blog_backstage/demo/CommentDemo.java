package com.karat.cn.blog_backstage.demo;

import com.karat.cn.blog_backstage.bean.Comment;
import com.karat.cn.blog_backstage.dao.CommentDao;
import com.karat.cn.blog_backstage.util.IdUtil;
import com.karat.cn.blog_backstage.util.TimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentDemo {

    @Autowired
    CommentDao commentDao;

    @Test
    public void addTest(){
        Comment comment1=new Comment(IdUtil.getOrderIdByTime(),"http://img5.imgtn.bdimg.com/it/u=1460089143,1479780884&fm=26&gp=0.jpg","小明","我是小明我是小明，收到请回答", TimeUtil.formateDbDate(TimeUtil.systemtime()),"1565868978848296618");
        Comment comment2=new Comment(IdUtil.getOrderIdByTime(),"http://img5.imgtn.bdimg.com/it/u=3389683750,3564498893&fm=26&gp=0.jpg","小强","人生若只如初见，何事秋风悲画扇。寂寞空庭春欲晚，梨花满地不开门。寂寞空庭春欲晚，梨花满地不开门。", TimeUtil.formateDbDate(TimeUtil.systemtime()),"1565869969730289496");
        Comment comment3=new Comment(IdUtil.getOrderIdByTime(),"http://img3.imgtn.bdimg.com/it/u=1677901248,1634112591&fm=26&gp=0.jpg","小红","曾经沧海难为水，除却巫山不是云。山重水复疑无路，柳暗花明又一村。山重水复疑无路，柳暗花明又一村。", TimeUtil.formateDbDate(TimeUtil.systemtime()),"1565869969730289496");
        Comment comment4=new Comment(IdUtil.getOrderIdByTime(),"http://img5.imgtn.bdimg.com/it/u=3230957845,3313776986&fm=26&gp=0.jpg","小黄","问君能有几多愁？恰似一江春水向东流。枯藤老树昏鸦，小桥流水人家，古道西风瘦马。枯藤老树昏鸦，小桥流水人家，古道西风瘦马。", TimeUtil.formateDbDate(TimeUtil.systemtime()),"1565869969730289496");

        commentDao.addComment(comment1);
        commentDao.addComment(comment2);
        commentDao.addComment(comment3);
        commentDao.addComment(comment4);
    }

}
