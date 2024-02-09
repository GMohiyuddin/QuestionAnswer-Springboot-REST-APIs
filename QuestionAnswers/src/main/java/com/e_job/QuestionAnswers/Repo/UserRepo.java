package com.e_job.QuestionAnswers.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_job.QuestionAnswers.Model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	User getUserByEmail(String email);

}
