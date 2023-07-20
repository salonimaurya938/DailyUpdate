package com.sabpaisa.entity;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TimeTable {
	
	@Id
	@GeneratedValue
	private int id;
	private Time schoolTime;
	private String sunday;
	private String monday;
	private String tuseday;
	private String wednesday;
	private String thrusday;
	private String friday;
	private String sturday;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Time getSchoolTime() {
		return schoolTime;
	}
	public void setSchoolTime(Time schoolTime) {
		this.schoolTime = schoolTime;
	}
	public String getSunday() {
		return sunday;
	}
	public void setSunday(String sunday) {
		this.sunday = sunday;
	}
	public String getMonday() {
		return monday;
	}
	public void setMonday(String monday) {
		this.monday = monday;
	}
	public String getTuseday() {
		return tuseday;
	}
	public void setTuseday(String tuseday) {
		this.tuseday = tuseday;
	}
	public String getWednesday() {
		return wednesday;
	}
	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}
	public String getThrusday() {
		return thrusday;
	}
	public void setThrusday(String thrusday) {
		this.thrusday = thrusday;
	}
	public String getFriday() {
		return friday;
	}
	public void setFriday(String friday) {
		this.friday = friday;
	}
	public String getSturday() {
		return sturday;
	}
	public void setSturday(String sturday) {
		this.sturday = sturday;
	}
	
}
