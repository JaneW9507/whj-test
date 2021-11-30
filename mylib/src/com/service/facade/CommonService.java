package com.service.facade;

import java.util.List;

import com.model.BookInfo;

public interface CommonService {

	//У���û��Ƿ����,���ڷ����û�����
	public String findUser(String userId,String password);
	//����ͼ��
	public void addBook(BookInfo book);
	//ɾ��ͼ��
	public void delBook(int id);
	//�༭ͼ����Ϣ
	public void updateBook(BookInfo book);
	//�鿴ͼ����
	public List<BookInfo> findAll();
	public BookInfo findById(int id);
}
