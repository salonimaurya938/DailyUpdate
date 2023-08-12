package com.sabpaisa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="upload_courses")
public class UploadCourses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String discription;
	private String classes;
	private String lesson;
	private String uploadCourse;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getLesson() {
		return lesson;
	}
	public void setLesson(String lesson) {
		this.lesson = lesson;
	}
	public String getUploadCourse() {
		return uploadCourse;
	}
	public void setUploadCourse(String uploadCourse) {
		this.uploadCourse = uploadCourse;
	}
	
	public UploadCourses(int id, String title, String discription, String classes, String lesson, String uploadCourse) {
		super();
		this.id = id;
		this.title = title;
		this.discription = discription;
		this.classes = classes;
		this.lesson = lesson;
		this.uploadCourse = uploadCourse;
	}
	
	@Override
	public String toString() {
		return "UploadCourses [id=" + id + ", title=" + title + ", discription=" + discription + ", classes=" + classes
				+ ", lesson=" + lesson + ", uploadCourse=" + uploadCourse + "]";
	}
	public UploadCourses() {
		super();
		// TODO Auto-generated constructor stub
	}

}
