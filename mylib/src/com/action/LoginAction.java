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

	private String userId;//��½�˺�
	private String password;//����
	private String userName;//�û���
	
	private CommonService commonService;
	
	public String login() throws Exception{
		//�����ݿ��ѯ����֤�û�Ȩ��
		userName = commonService.findUser(userId, password);
		if("".equals(userName)){//�û�������
			return this.INPUT;
		}
		return this.SUCCESS;
	}
	//�˳�����
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
