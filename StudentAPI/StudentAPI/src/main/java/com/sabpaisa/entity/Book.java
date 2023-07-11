package com.sabpaisa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name="library_book")
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String subName;
	private String subTitle;
	private String subIcon;
	private String substatus;
	
	public Book(int id, String subName, String subTitle, String subIcon, String substatus) {
		super();
		this.id = id;
		this.subName = subName;
		this.subTitle = subTitle;
		this.subIcon = subIcon;
		this.substatus = substatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getSubIcon() {
		return subIcon;
	}
	public void setSubIcon(String subIcon) {
		this.subIcon = subIcon;
	}
	public String getSubstatus() {
		return substatus;
	}
	public void setSubstatus(String substatus) {
		this.substatus = substatus;
	}
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", subName=" + subName + ", subTitle=" + subTitle + ", subIcon=" + subIcon
				+ ", substatus=" + substatus + "]";
	}
	
	
}
