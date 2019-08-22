package com.karat.cn.blog_backstage.util;

import com.karat.cn.blog_backstage.bean.User;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {

    /**
     * 集合分页
     *
     * @param list 要分页的集合
     * @param pageIndex    页码
     * @param pageSize     每页条数
     * @return 分页后的集合
     */
    public static List<User> getPageByList(List<User> list, int pageIndex, int pageSize) {
        List<User> pageList = new ArrayList<>();
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        int size = list.size();
        int pageCount = size / pageSize;
        int fromIndex = (pageIndex - 1) * pageSize;
        int toIndex = fromIndex + pageSize;
        if (toIndex >= size) {
            toIndex = size;
        }
        if (pageIndex > pageCount + 1) {
            fromIndex = 0;
            toIndex = 0;
        }
        pageList = list.subList(fromIndex,toIndex);
        return pageList;
    }
}
