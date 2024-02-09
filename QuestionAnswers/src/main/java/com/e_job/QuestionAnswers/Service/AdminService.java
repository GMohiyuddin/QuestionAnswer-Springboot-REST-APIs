package com.e_job.QuestionAnswers.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_job.QuestionAnswers.Model.AdminModel;
import com.e_job.QuestionAnswers.Repo.AdminRepo;

@Service
public class AdminService {
	@Autowired
	AdminRepo repo;

	public AdminModel signup(AdminModel admin) {
		return repo.save(admin);
	}

	
}
