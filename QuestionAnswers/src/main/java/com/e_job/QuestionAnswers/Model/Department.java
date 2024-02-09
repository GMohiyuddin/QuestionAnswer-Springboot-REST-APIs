package com.e_job.QuestionAnswers.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int depart_id;
	private String name;
	@OneToMany
	private List<Question> questions;
	@OneToMany
	private List<User> user;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Department(int depart_id, String name, List<Question> questions, List<User> user) {
		super();
		this.depart_id = depart_id;
		this.name = name;
		this.questions = questions;
		this.user = user;
	}

	public List<User> getUser() {
		return user;
	}



	public void setUser(List<User> user) {
		this.user = user;
	}



	public int getDepart_id() {
		return depart_id;
	}

	public void setDepart_id(int depart_id) {
		this.depart_id = depart_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public List<Question> getQuestions() {
		return questions;
	}



	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}



	@Override
	public String toString() {
		return "Department [depart_id=" + depart_id + ", name=" + name + ", questions=" + questions + ", user=" + user
				+ "]";
	}

}
