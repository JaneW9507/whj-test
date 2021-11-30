package com.action;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.BookInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.service.facade.CommonService;

public class ManagerAction extends ActionSupport{

	private String userId;//µÇÂ½ÕËºÅ
	private String password;//ÃÜÂë
	private String userName;//ÓÃ»§Ãû
	private String id;
	private CommonService commonService;
	private BookInfo book;
	public List<BookInfo> list=new ArrayList<BookInfo>();
	
	public String addBook(){
		if(book!=null){
			if(book.getId()>0){
				commonService.updateBook(book);
			}else{
				Date indate = new Date();
				book.setIndate(indate);
				commonService.addBook(book);
			}
		}
		return this.SUCCESS;
	}
	public String updateBook(){
		if(id!=null && !"".equals(id)){
			int bookId = Integer.parseInt(id);
			book = commonService.findById(bookId);
		}
		return this.SUCCESS;
	}
	public String delBook(){
		if(id!=null && !"".equals(id)){
			int bookId = Integer.parseInt(id);
			commonService.delBook(bookId);
		}
		return this.SUCCESS;
	}
	public String findBooks(){
		list = commonService.findAll();
		return this.SUCCESS;
	}
	
	
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
	public BookInfo getBook() {
		return book;
	}
	public void setBook(BookInfo book) {
		this.book = book;
	}
	public List<BookInfo> getList() {
		return list;
	}
	public void setList(List<BookInfo> list) {
		this.list = list;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
