package com.sabpaisa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class QuizDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String subject;
	private String totalTime;
	private String classes;
	private String title;
	private String marks;
	private String negativeMarks;
	private String category;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getNegativeMarks() {
		return negativeMarks;
	}
	public void setNegativeMarks(String negativeMarks) {
		this.negativeMarks = negativeMarks;
	}
		
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public QuizDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuizDetails(int id, String subject, String totalTime, String classes, String title, String marks,
			String negativeMarks, String category) {
		super();
		this.id = id;
		this.subject = subject;
		this.totalTime = totalTime;
		this.classes = classes;
		this.title = title;
		this.marks = marks;
		this.negativeMarks = negativeMarks;
		this.category = category;
	}
	@Override
	public String toString() {
		return "QuizDetails [id=" + id + ", subject=" + subject + ", totalTime=" + totalTime + ", classes=" + classes
				+ ", title=" + title + ", marks=" + marks + ", negativeMarks=" + negativeMarks + ", category="
				+ category + "]";
	}	
	
}
