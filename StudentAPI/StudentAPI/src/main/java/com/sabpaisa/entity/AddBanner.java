package com.sabpaisa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="addBanner")
public class AddBanner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bannerId;
	private String banner;
	private String pageName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBannerId() {
		return bannerId;
	}
	public void setBannerId(String bannerId) {
		this.bannerId = bannerId;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	
	public AddBanner() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AddBanner(int id, String bannerId, String banner, String pageName) {
		super();
		this.id = id;
		this.bannerId = bannerId;
		this.banner = banner;
		this.pageName = pageName;
	}
	
	@Override
	public String toString() {
		return "AddBanner [id=" + id + ", bannerId=" + bannerId + ", banner=" + banner + ", pageName=" + pageName + "]";
	}
		
}
