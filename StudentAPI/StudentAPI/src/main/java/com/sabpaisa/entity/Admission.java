package com.sabpaisa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="addmission")
public class Admission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String admissionNo;
	private byte[] stdProfile;
	private byte[] fProfile;
	private byte[] mProfile;
	private String name;
	private String fname;
	private String mname;
	private String dob;
	private String gender;
	private String bloodGroup;
	private String classes;
	private String address;
	private String gmail;
	private String district;
	private String state;
	private String pincode;
	private String aadharNo;
	private String fqulification;
	private String mqulification;
	private String foccupation;
	private String pmob;
	private String receiptNo;
	private String amount;
	private String registrationNo;
	private String classAdmittedinto;
	private String rollNo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdmissionNo() {
		return admissionNo;
	}
	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getFqulification() {
		return fqulification;
	}
	public void setFqulification(String fqulification) {
		this.fqulification = fqulification;
	}
	public String getMqulification() {
		return mqulification;
	}
	public void setMqulification(String mqulification) {
		this.mqulification = mqulification;
	}
	public String getFoccupation() {
		return foccupation;
	}
	public void setFoccupation(String foccupation) {
		this.foccupation = foccupation;
	}
	public String getPmob() {
		return pmob;
	}
	public void setPmob(String pmob) {
		this.pmob = pmob;
	}
	public String getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getClassAdmittedinto() {
		return classAdmittedinto;
	}
	public void setClassAdmittedinto(String classAdmittedinto) {
		this.classAdmittedinto = classAdmittedinto;
	}	
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}	
	public byte[] getStdProfile() {
		return stdProfile;
	}
	public void setStdProfile(byte[] stdProfile) {
		this.stdProfile = stdProfile;
	}
	public byte[] getfProfile() {
		return fProfile;
	}
	public void setfProfile(byte[] fProfile) {
		this.fProfile = fProfile;
	}
	public byte[] getmProfile() {
		return mProfile;
	}
	public void setmProfile(byte[] mProfile) {
		this.mProfile = mProfile;
	}
	public Admission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admission(int id, String admissionNo, byte[] stdProfile, byte[] fProfile, byte[] mProfile, String name,
			String fname, String mname, String dob, String gender, String bloodGroup, String classes, String address,
			String gmail, String district, String state, String pincode, String aadharNo, String fqulification,
			String mqulification, String foccupation, String pmob, String receiptNo, String amount,
			String registrationNo, String classAdmittedinto, String rollNo) {
		super();
		this.id = id;
		this.admissionNo = admissionNo;
		this.stdProfile = stdProfile;
		this.fProfile = fProfile;
		this.mProfile = mProfile;
		this.name = name;
		this.fname = fname;
		this.mname = mname;
		this.dob = dob;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.classes = classes;
		this.address = address;
		this.gmail = gmail;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
		this.aadharNo = aadharNo;
		this.fqulification = fqulification;
		this.mqulification = mqulification;
		this.foccupation = foccupation;
		this.pmob = pmob;
		this.receiptNo = receiptNo;
		this.amount = amount;
		this.registrationNo = registrationNo;
		this.classAdmittedinto = classAdmittedinto;
		this.rollNo = rollNo;
	}
	
	
}
