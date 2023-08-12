package com.sabpaisa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student_fee")
public class Fee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String rollNo;
	private String classes;
	private String fee;
	private String date;
	private String feeType;
	
	
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
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public Fee(int id, String name, String rollNo, String classes, String fee, String date, String feeType) {
		super();
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
		this.classes = classes;
		this.fee = fee;
		this.date = date;
		this.feeType = feeType;
	}
	@Override
	public String toString() {
		return "fee [id=" + id + ", name=" + name + ", rollNo=" + rollNo + ", classes=" + classes + ", fee=" + fee
				+ ", date=" + date + ", feeType=" + feeType + "]";
	}
	public Fee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
