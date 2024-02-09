package com.e_job.QuestionAnswers.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int Uid;
	private String email, password;
	@ManyToOne
	private Department department;

	public User(int uid, String email, String password, Department department) {
		super();
		Uid = uid;
		this.email = email;
		this.password = password;
		this.department = department;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUid() {
		return Uid;
	}

	public void setUid(int uid) {
		Uid = uid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "User [Uid=" + Uid + ", email=" + email + ", password=" + password + ", department=" + department + "]";
	}

}
