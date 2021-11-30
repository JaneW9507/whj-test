package com.service.spring;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.BookInfo;
import com.model.UserInfo;
import com.service.facade.CommonService;

public class CommonServiceImpl implements CommonService{

	private SessionFactory sessionFactory;
	
	private static CacheManager cacheManager = CacheManager.getIntance("Users");
	
	@Override
	public String findUser(String userId, String password) {
		Object result = cacheManager.getCache(userId+password);
		if (result != null) {
			return (String) result;
		}else{
			String name = "";
			try{
				Session session = sessionFactory.openSession();
				Query query = session.createQuery(" from UserInfo where userId = ?  and password = ? ");
				int id = Integer.parseInt(userId);
				query.setParameter(0, id);
				query.setParameter(1, password);
				UserInfo user=(UserInfo) query.uniqueResult();
				if(user!=null){
					name = user.getUserName();
					cacheManager.putCache(userId+password, name);
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			return name;
		}
	}

	@Override
	public void addBook(BookInfo book) {
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.getTransaction();
			tx.begin();
			session.save(book);
			tx.commit();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	public void updateBook(BookInfo book) {
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.getTransaction();
			tx.begin();
			session.saveOrUpdate(book);
			tx.commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	public void delBook(int id) {
		try{
			
			Session session=sessionFactory.openSession();
			Transaction tx=session.getTransaction();
			tx.begin();
			session.delete(session.get(BookInfo.class, id));
			tx.commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	@Override
	public List<BookInfo> findAll() {
		List<BookInfo>  list = new ArrayList<BookInfo>(0);
		try{
			
			Session session=sessionFactory.openSession();
			list = session.createQuery(" from BookInfo ").list();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return list;
	}
	
	@Override
	public BookInfo findById(int id) {
		BookInfo book = null;
		try{
			Session session=sessionFactory.openSession();
			book = (BookInfo) session.get(BookInfo.class, id);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return book;
	}

	//-------getters and setters -------
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	
}
