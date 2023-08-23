package com.sabpaisa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="option")
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String op1;
	private String op2;
	private String op3;
	private String op4;
	private String correctAnswer;	
	
	public Option() {
		super();
	}
	
	public Option(int id, String op1, String op2, String op3, String op4, String correctAnswer) {
		super();
		this.id = id;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
		this.correctAnswer = correctAnswer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOp1() {
		return op1;
	}
	public void setOp1(String op1) {
		this.op1 = op1;
	}
	public String getOp2() {
		return op2;
	}
	public void setOp2(String op2) {
		this.op2 = op2;
	}
	public String getOp3() {
		return op3;
	}
	public void setOp3(String op3) {
		this.op3 = op3;
	}
	public String getOp4() {
		return op4;
	}
	public void setOp4(String op4) {
		this.op4 = op4;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String toString() {
		return "Option [id=" + id + ", op1=" + op1 + ", op2=" + op2 + ", op3=" + op3 + ", op4=" + op4
				+ ", correctAnswer=" + correctAnswer + "]";
	}

	
	
	
}
