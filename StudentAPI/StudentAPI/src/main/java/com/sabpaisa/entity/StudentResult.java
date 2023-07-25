package com.sabpaisa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentResult {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String classes;
	private String dob;
	private String rollNo;
	private String division;
	private String totalMarks;
	private String obtainedMarks;
	private String result;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(String totalMarks) {
		this.totalMarks = totalMarks;
	}
	public String getObtainedMarks() {
		return obtainedMarks;
	}
	public void setObTainedMarks(String obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}
	public StudentResult(int id, String name, String classes, String dob, String rollNo, String division,
			String totalMarks, String obtainedMarks, String result) {
		super();
		this.id = id;
		this.name = name;
		this.classes = classes;
		this.dob = dob;
		this.rollNo = rollNo;
		this.division = division;
		this.totalMarks = totalMarks;
		this.obtainedMarks = obtainedMarks;
		this.result = result;
	}
	@Override
	public String toString() {
		return "StudentResult [id=" + id + ", name=" + name + ", classes=" + classes + ", dob=" + dob + ", rollNo="
				+ rollNo + ", division=" + division + ", totalMarks=" + totalMarks + ", obtainedMarks=" + obtainedMarks
				+ ", result=" + result + "]";
	}
	public StudentResult() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	
	

}
