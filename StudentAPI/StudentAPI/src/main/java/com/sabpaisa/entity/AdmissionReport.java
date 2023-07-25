package com.sabpaisa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admission_report")
public class AdmissionReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String classSection;
	private String fatherName;
	private String motherName;
	private String Address;
	private String totalFee;
	private String paidFee;
	private String remainFee;
	
	public AdmissionReport(int id, String name, String classSection, String fatherName, String motherName,
			String address, String totalFee, String paidFee, String remainFee) {
		super();
		this.id = id;
		this.name = name;
		this.classSection = classSection;
		this.fatherName = fatherName;
		this.motherName = motherName;
		Address = address;
		this.totalFee = totalFee;
		this.paidFee = paidFee;
		this.remainFee = remainFee;
		
		
	}

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

	public String getClassSection() {
		return classSection;
	}

	public void setClassSection(String classSection) {
		this.classSection = classSection;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getPaidFee() {
		return paidFee;
	}

	public void setPaidFee(String paidFee) {
		this.paidFee = paidFee;
	}

	public String getRemainFee() {
		return remainFee;
	}

	public void setRemainFee(String remainFee) {
		this.remainFee = remainFee;
	}

	@Override
	public String toString() {
		return "AdmissionReport [id=" + id + ", name=" + name + ", classSection=" + classSection + ", fatherName="
				+ fatherName + ", motherName=" + motherName + ", Address=" + Address + ", totalFee=" + totalFee
				+ ", paidFee=" + paidFee + ", remainFee=" + remainFee + "]";
	}

	public AdmissionReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
