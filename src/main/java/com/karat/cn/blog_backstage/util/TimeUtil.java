package com.karat.cn.blog_backstage.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtil {

    /**
     * 获取系统时间
     *
     * @return
     * @throws ParseException
     */
    public static Date systemtime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String dateString = formatter.format(date);
        ParsePosition pos = new ParsePosition(0);
        Date currenttime = formatter.parse(dateString, pos);
        return currenttime;
    }

    /**
     * 获取系统时间long
     *
     * @return
     * @throws ParseException
     */
    public static long systemtimeLong() {
        return new Date().getTime();
    }

    /**
     * 转换数据库日期格式
     *
     * @param object
     * @return
     */
    public static String formateDbDate(Date object) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
        String dateString = formatter.format(object);
        return dateString;
    }
}
