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
	private String stdProfile;
	private String name;
	private String fname;
	private String mname;
	private String dob;
	private String gender;
	private String bloodGroup;
	private String address;
	private String gmail;
	private String policeStation;
	private String postoffice;
	private String district;
	private String state;
	private String pincode;
	private String smob;
	private String aadharNo;
	private String fqulification;
	private String mqulification;
	private String foccupation;
	private String moccupation;
	private String localGuardian;
	private String relationWithStudent;
	private String pmob;
	private String receiptNo;
	private String amount;
	private String datedNo;
	private String stdName;
	private String AdmissionNo2;
	private String dateofadmission;
	private String classAdmittedinto;
	private String section;
	
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
	public String getStdProfile() {
		return stdProfile;
	}
	public void setStdProfile(String stdProfile) {
		this.stdProfile = stdProfile;
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
	public String getPoliceStation() {
		return policeStation;
	}
	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}
	public String getPostoffice() {
		return postoffice;
	}
	public void setPostoffice(String postoffice) {
		this.postoffice = postoffice;
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
	public String getSmob() {
		return smob;
	}
	public void setSmob(String smob) {
		this.smob = smob;
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
	public String getMoccupation() {
		return moccupation;
	}
	public void setMoccupation(String moccupation) {
		this.moccupation = moccupation;
	}
	public String getLocalGuardian() {
		return localGuardian;
	}
	public void setLocalGuardian(String localGuardian) {
		this.localGuardian = localGuardian;
	}
	public String getRelationWithStudent() {
		return relationWithStudent;
	}
	public void setRelationWithStudent(String relationWithStudent) {
		this.relationWithStudent = relationWithStudent;
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
	public String getDatedNo() {
		return datedNo;
	}
	public void setDatedNo(String datedNo) {
		this.datedNo = datedNo;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getAdmissionNo2() {
		return AdmissionNo2;
	}
	public void setAdmissionNo2(String admissionNo2) {
		AdmissionNo2 = admissionNo2;
	}
	public String getDateofadmission() {
		return dateofadmission;
	}
	public void setDateofadmission(String dateofadmission) {
		this.dateofadmission = dateofadmission;
	}
	public String getClassAdmittedinto() {
		return classAdmittedinto;
	}
	public void setClassAdmittedinto(String classAdmittedinto) {
		this.classAdmittedinto = classAdmittedinto;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
		
	public Admission(int id, String admissionNo, String stdProfile, String name, String fname, String mname,
			String dob, String gender, String bloodGroup, String address, String gmail, String policeStation,
			String postoffice, String district, String state, String pincode, String smob, String aadharNo,
			String fqulification, String mqulification, String foccupation, String moccupation, String localGuardian,
			String relationWithStudent, String pmob, String receiptNo, String amount, String datedNo, String stdName,
			String admissionNo2, String dateofadmission, String classAdmittedinto, String section) {
		super();
		this.id = id;
		this.admissionNo = admissionNo;
		this.stdProfile = stdProfile;
		this.name = name;
		this.fname = fname;
		this.mname = mname;
		this.dob = dob;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.address = address;
		this.gmail = gmail;
		this.policeStation = policeStation;
		this.postoffice = postoffice;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
		this.smob = smob;
		this.aadharNo = aadharNo;
		this.fqulification = fqulification;
		this.mqulification = mqulification;
		this.foccupation = foccupation;
		this.moccupation = moccupation;
		this.localGuardian = localGuardian;
		this.relationWithStudent = relationWithStudent;
		this.pmob = pmob;
		this.receiptNo = receiptNo;
		this.amount = amount;
		this.datedNo = datedNo;
		this.stdName = stdName;
		AdmissionNo2 = admissionNo2;
		this.dateofadmission = dateofadmission;
		this.classAdmittedinto = classAdmittedinto;
		this.section = section;
	}
		
	public Admission() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Addmission [id=" + id + ", admissionNo=" + admissionNo + ", stdProfile=" + stdProfile + ", name=" + name
				+ ", fname=" + fname + ", mname=" + mname + ", dob=" + dob + ", gender=" + gender + ", bloodGroup="
				+ bloodGroup + ", address=" + address + ", gmail=" + gmail + ", policeStation=" + policeStation
				+ ", postoffice=" + postoffice + ", district=" + district + ", state=" + state + ", pincode=" + pincode
				+ ", smob=" + smob + ", aadharNo=" + aadharNo + ", fqulification=" + fqulification + ", mqulification="
				+ mqulification + ", foccupation=" + foccupation + ", moccupation=" + moccupation + ", localGuardian="
				+ localGuardian + ", relationWithStudent=" + relationWithStudent + ", pmob=" + pmob + ", receiptNo="
				+ receiptNo + ", amount=" + amount + ", datedNo=" + datedNo + ", stdName=" + stdName + ", AdmissionNo2="
				+ AdmissionNo2 + ", dateofadmission=" + dateofadmission + ", classAdmittedinto=" + classAdmittedinto
				+ ", section=" + section + "]";
	}	
	 
}
