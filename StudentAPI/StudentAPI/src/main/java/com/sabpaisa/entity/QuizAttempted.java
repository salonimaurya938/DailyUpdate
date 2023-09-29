package com.sabpaisa.entity;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class QuizAttempted {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String admission_id;
	@ElementCollection
	private List<String> category;
	@ElementCollection
	private List<String> quizId;
	@ElementCollection
	private List<String> option;
	private String answer;
	private String status;
	private String score;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdmission_id() {
		return admission_id;
	}
	public void setAdmission_id(String admission_id) {
		this.admission_id = admission_id;
	}
	public List<String> getCategory() {
		return category;
	}
	public void setCategory(List<String> category) {
		this.category = category;
	}
	public List<String> getQuizId() {
		return quizId;
	}
	public void setQuizId(List<String> quizId) {
		this.quizId = quizId;
	}
	public List<String> getOption() {
		return option;
	}
	public void setOption(List<String> option) {
		this.option = option;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public QuizAttempted(int id, String admission_id, List<String> category, List<String> quizId, List<String> option,
			String answer, String status, String score) {
		super();
		this.id = id;
		this.admission_id = admission_id;
		this.category = category;
		this.quizId = quizId;
		this.option = option;
		this.answer = answer;
		this.status = status;
		this.score = score;
	}
	public QuizAttempted() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "QuizAttempted [id=" + id + ", admission_id=" + admission_id + ", category=" + category + ", quizId="
				+ quizId + ", option=" + option + ", answer=" + answer + ", status=" + status + ", score=" + score
				+ "]";
	}
    	

}
