package com.karat.cn.blog_backstage.vo.view;
/**
 * 状态描述vo
 * @author 开发
 *
 */
public class ResponseLogin {
	String state;
	
	public ResponseLogin(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
