package com.karat.cn.blog_backstage.vo.view;

/**
 * 数据统计
 */
public class ResponseNumVo {

    //博客数
    private int blogNum;
    //用户数
    private int userNum;
    //评论数
    private int commentNum;
    //标签数
    private int tagNum;
    //友链数量
    private int friendNum;

    public ResponseNumVo() {
    }

    public ResponseNumVo(int blogNum, int userNum, int commentNum, int tagNum, int friendNum) {
        this.blogNum = blogNum;
        this.userNum = userNum;
        this.commentNum = commentNum;
        this.tagNum = tagNum;
        this.friendNum = friendNum;
    }

    public int getBlogNum() {
        return blogNum;
    }

    public void setBlogNum(int blogNum) {
        this.blogNum = blogNum;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getTagNum() {
        return tagNum;
    }

    public void setTagNum(int tagNum) {
        this.tagNum = tagNum;
    }

    public int getFriendNum() {
        return friendNum;
    }

    public void setFriendNum(int friendNum) {
        this.friendNum = friendNum;
    }
}
