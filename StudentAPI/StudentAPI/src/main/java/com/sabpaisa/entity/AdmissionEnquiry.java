package com.sabpaisa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admission_enquiry")
public class AdmissionEnquiry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String mob;
	private String email;
	private String classes;
	private String address;
	private String description;
	private String dateTime;
	private String assigned;
	private String reference;
	private String source;
	
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
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getAssigned() {
		return assigned;
	}
	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public AdmissionEnquiry(int id, String name, String mob, String email, String classes, String address,
			String description, String dateTime, String assigned, String reference, String source) {
		super();
		this.id = id;
		this.name = name;
		this.mob = mob;
		this.email = email;
		this.classes = classes;
		this.address = address;
		this.description = description;
		this.dateTime = dateTime;
		this.assigned = assigned;
		this.reference = reference;
		this.source = source;
	}
	@Override
	public String toString() {
		return "AdmissionEnquiry [id=" + id + ", name=" + name + ", mob=" + mob + ", email=" + email + ", classes="
				+ classes + ", address=" + address + ", description=" + description + ", dateTime=" + dateTime
				+ ", assigned=" + assigned + ", reference=" + reference + ", source=" + source + "]";
	}
	public AdmissionEnquiry() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
