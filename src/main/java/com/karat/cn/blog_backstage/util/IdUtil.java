package com.karat.cn.blog_backstage.util;

import java.util.Date;

/**
 * 随机不重复数字
 */
public class IdUtil {

    public static String getOrderIdByTime() {
        return new Date().getTime()+String.valueOf((int)((Math.random()*9+1)*100000));
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            System.out.println(getOrderIdByTime());
        }
    }
}
