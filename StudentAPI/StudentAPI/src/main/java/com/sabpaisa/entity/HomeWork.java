package com.sabpaisa.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="home_work")
public class HomeWork {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String question;
	
	public HomeWork(int id, String question) {
		super();
		this.id = id;
		this.question = question;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public HomeWork() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "HomeWork [id=" + id + ", question=" + question + "]";
	}
		
	
}
