package com.model;

import java.math.BigDecimal;
import java.util.Date;

public class BookInfo implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String author;
	private String press;
	private BigDecimal price;
	private Date indate;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

}
