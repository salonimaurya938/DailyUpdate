package com.sabpaisa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="library_chapter")
@Entity
public class Chapter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String chapName;
	private String chapDescription;
	private String subid;
	
	
	public Chapter(int id, String chapName, String chapDescription, String subid) {
		super();
		this.id = id;
		this.chapName = chapName;
		this.chapDescription = chapDescription;
		this.subid = subid;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getChapName() {
		return chapName;
	}


	public void setChapName(String chapName) {
		this.chapName = chapName;
	}


	public String getChapDescription() {
		return chapDescription;
	}


	public void setChapDescription(String chapDescription) {
		this.chapDescription = chapDescription;
	}


	public String getSubid() {
		return subid;
	}


	public void setSubid(String subid) {
		this.subid = subid;
	}


	public Chapter() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Chapter [id=" + id + ", chapName=" + chapName + ", chapDescription=" + chapDescription + ", subid="
				+ subid + "]";
	}

}
