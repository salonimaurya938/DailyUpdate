package com.sabpaisa.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Table(name="tbl_register")
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String classid;
	private String parentid;
	private String studentName;
	private String modile;
	private String email;
	private String password;
	private String classes;
	private String medium;
	private String rollNo;
	private String dob;
	private String bloodGroup;
	private String homeAddress;
	private String weight;
	private String height;	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String classid, String parentid, String studentName, String modile, String email,
			String password, String classes, String medium, String rollNo, String dob, String bloodGroup,
			String homeAddress, String weight, String height) {
		super();
		this.id = id;
		this.classid = classid;
		this.parentid = parentid;
		this.studentName = studentName;
		this.modile = modile;
		this.email = email;
		this.password = password;
		this.classes = classes;
		this.medium = medium;
		this.rollNo = rollNo;
		this.dob = dob;
		this.bloodGroup = bloodGroup;
		this.homeAddress = homeAddress;
		this.weight = weight;
		this.height = height;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getModile() {
		return modile;
	}

	public void setModile(String modile) {
		this.modile = modile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", classid=" + classid + ", parentid=" + parentid + ", studentName=" + studentName
				+ ", modile=" + modile + ", email=" + email + ", password=" + password + ", classes=" + classes
				+ ", medium=" + medium + ", rollNo=" + rollNo + ", dob=" + dob + ", bloodGroup=" + bloodGroup
				+ ", homeAddress=" + homeAddress + ", weight=" + weight + ", height=" + height + "]";
	}
	
	
//	INSERT INTO `tbl_register` (`id`, `blood_group`, `classes`, `classid`, `dob`, `email`, `height`, `home_address`, `medium`, `modile`, `parentid`, `password`, `roll_no`, `student_name`, `weight`) VALUES ('1', 'A', '2a', '12', '03/03/2003', 'saloni@gmial.com', '5.2', 'gorakhpur', 'hindi', '8786844837', '23', '123', '6', 'saloni', '60');
	
}

