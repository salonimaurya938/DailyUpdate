package com.sabpaisa.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="quiz")
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String question;	
	@OneToMany(targetEntity=Option.class)  
	@JoinColumn(name = "oq_fk", referencedColumnName = "id")
	private List<Option> option;
	
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
	public List<Option> getOption() {
		return option;
	}

	public void setOption(List<Option> option) {
		this.option = option;
	}

	public Quiz(int id, String question, List<Option> option) {
		super();
		this.id = id;
		this.question = question;
		this.option = option;
	}
	
	

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", question=" + question + ", option=" + option + "]";
	}

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
