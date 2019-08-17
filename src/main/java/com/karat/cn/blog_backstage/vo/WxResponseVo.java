package com.karat.cn.blog_backstage.vo;

/**
 * 微信code返回openId
 */
public class WxResponseVo {

    //状态吗
    private String code;
    //状态描述
    private String msg;
    //用户唯一openId
    private String openid;

    public WxResponseVo() {
    }

    public WxResponseVo(String code, String msg, String openid) {
        this.code = code;
        this.msg = msg;
        this.openid = openid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
