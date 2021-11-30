package com.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.model.UserInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.service.facade.CommonService;
import com.service.spring.CommonServiceImpl;

public class LoginAction extends ActionSupport{

	private String userId;//登陆账号
	private String password;//密码
	private String userName;//用户名
	
	private CommonService commonService;
	
	public String login() throws Exception{
		//从数据库查询，验证用户权限
		userName = commonService.findUser(userId, password);
		if("".equals(userName)){//用户不存在
			return this.INPUT;
		}
		return this.SUCCESS;
	}
	//退出方法
	public String loginOut(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.invalidate();
		return this.SUCCESS;
	}
	//----------getters and setters----------
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public CommonService getCommonService() {
		return commonService;
	}
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	
}
