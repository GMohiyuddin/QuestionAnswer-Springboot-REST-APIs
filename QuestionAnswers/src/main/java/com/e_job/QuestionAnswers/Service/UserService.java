package com.e_job.QuestionAnswers.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_job.QuestionAnswers.Model.User;
import com.e_job.QuestionAnswers.Repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo uRepo;

	public User authUser(String email, String password) {
		// TODO Auto-generated method stub
		User user = uRepo.getUserByEmail(email);
		if (user != null && user.getPassword().equals(password)) {

			return user;
		} else {
			return null;
		}
	}
	public Optional<User> getUser(int Uid) {
		Optional<User> u1 = uRepo.findById(Uid);
		return u1;

	}
}
