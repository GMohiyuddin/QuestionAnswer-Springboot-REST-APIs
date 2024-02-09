package com.e_job.QuestionAnswers.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.e_job.QuestionAnswers.Model.AdminModel;
import com.e_job.QuestionAnswers.Model.Question;
import com.e_job.QuestionAnswers.Repo.AdminRepo;
import com.e_job.QuestionAnswers.Service.AdminService;
import com.e_job.QuestionAnswers.Service.QuestionService;

@RestController
public class AdminController {
	
	@Autowired
	AdminService Aservice;
	@Autowired
	QuestionService Qservice;
	
	@Autowired
	AdminRepo repo;
	
	@GetMapping("/signuppageadmin")
	public String signUpPage() {
		return "signup page for Admin";
	}
	@PostMapping("signupadmin")
	public ResponseEntity<AdminModel> signUpAdmin(@RequestBody AdminModel admin) {
		AdminModel admin1 = Aservice.signup(admin);
		return new ResponseEntity<>(admin1,HttpStatus.CREATED);
	}
	@PostMapping("questionupload")
	public ResponseEntity<Question> addquestion(@RequestBody Question que){
		Question question = Qservice.addquestion(que);
		return new ResponseEntity<>(question , HttpStatus.CREATED);
	}
}
