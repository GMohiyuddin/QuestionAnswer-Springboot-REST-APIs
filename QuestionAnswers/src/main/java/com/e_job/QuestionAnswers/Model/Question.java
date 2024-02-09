package com.e_job.QuestionAnswers.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int Qid;
	private String Question, Option1, Option2, Option3, RightAnswer;
	@ManyToOne
	@JoinColumn(name = "depart_id") // specify the join column
	private Department department;

	public Question(int qid, String question, String option1, String option2, String option3, String rightAnswer,
			Department department) {
		super();
		Qid = qid;
		Question = question;
		Option1 = option1;
		Option2 = option2;
		Option3 = option3;
		RightAnswer = rightAnswer;
		this.department = department;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public int getQid() {
		return Qid;
	}

	public void setQid(int qid) {
		Qid = qid;
	}

	public String getOption1() {
		return Option1;
	}

	public void setOption1(String option1) {
		Option1 = option1;
	}

	public String getOption2() {
		return Option2;
	}

	public void setOption2(String option2) {
		Option2 = option2;
	}

	public String getOption3() {
		return Option3;
	}

	public void setOption3(String option3) {
		Option3 = option3;
	}

	public String getRightAnswer() {
		return RightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		RightAnswer = rightAnswer;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Question [Qid=" + Qid + ", Question=" + Question + ", Option1=" + Option1 + ", Option2=" + Option2
				+ ", Option3=" + Option3 + ", RightAnswer=" + RightAnswer + ", department=" + department + "]";
	}

}
