package com.sabpaisa.dto;


public class QuizDto {
	
	private String id;
	private String question;
	private String option;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}	
	
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	@Override
	public String toString() {
		return "QuizDto [id=" + id + ", question=" + question + ", option=" + option + "]";
	}
	
}
