package com.service.facade;

import java.util.List;

import com.model.BookInfo;

public interface CommonService {

	//校验用户是否存在,存在返回用户姓名
	public String findUser(String userId,String password);
	//增加图书
	public void addBook(BookInfo book);
	//删除图书
	public void delBook(int id);
	//编辑图书信息
	public void updateBook(BookInfo book);
	//查看图书库存
	public List<BookInfo> findAll();
	public BookInfo findById(int id);
}
