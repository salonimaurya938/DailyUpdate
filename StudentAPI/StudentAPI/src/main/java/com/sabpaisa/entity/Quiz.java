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
	private String answer;
	private String category;
	private String score;
	private String status;
	
	
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
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quiz(int id, String question, List<Option> option, String answer, String category, String score,
			String status) {
		super();
		this.id = id;
		this.question = question;
		this.option = option;
		this.answer = answer;
		this.category = category;
		this.score = score;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", question=" + question + ", option=" + option + ", answer=" + answer + ", category="
				+ category + ", score=" + score + ", status=" + status + "]";
	}		

}
