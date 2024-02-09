package com.e_job.QuestionAnswers.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.e_job.QuestionAnswers.Model.Department;
import com.e_job.QuestionAnswers.Model.Question;
import com.e_job.QuestionAnswers.Model.User;
import com.e_job.QuestionAnswers.Repo.UserRepo;
import com.e_job.QuestionAnswers.Service.QuestionService;
import com.e_job.QuestionAnswers.Service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService uService;
	@Autowired
	QuestionService Qservice;
	@Autowired
	UserRepo uRepo;

	@PostMapping("/createUser")
	public ResponseEntity<User> SignupUser(@RequestBody User u) {
		User u1 = uRepo.save(u);
		return new ResponseEntity<>(u1, HttpStatus.CREATED);
	}

	@PostMapping("login")
	public ResponseEntity<String> loginUser(@RequestBody User LUser, HttpSession session) {
		User authUser = uService.authUser(LUser.getEmail(), LUser.getPassword());
		if (authUser != null) {
			session.setAttribute("Uid", +authUser.getUid());
			return ResponseEntity.ok("login successful and session created" + " User id is " + authUser.getUid());
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		}
	}

	@GetMapping("{Uid}/getquestion")
	public ResponseEntity<?> getquestion(@PathVariable int Uid, HttpSession session) {

		Integer userId = (Integer) session.getAttribute("Uid");

		if (userId != null && userId == Uid) {
			Optional<User> u1 = uService.getUser(userId);
			if (u1.isPresent()) {
				User user = u1.get();
				Department department = user.getDepartment();
				if (department != null) {
					int depart_id = department.getDepart_id();
					List<Question> q1 = (List<Question>) Qservice.getQuestionByDId(depart_id);
					return ResponseEntity.ok(q1);
				} else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User department is null");
				}
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not Found");
			}
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
	}

	@PostMapping("{Uid}/Submitanswer")
	public ResponseEntity<?> submitanswers(@PathVariable int Uid, HttpSession session,
			@RequestBody List<Map<String, Object>> userResponses) {
		Integer UserId = (Integer) session.getAttribute("Uid");
		int correctAnswers = 0;
		if (UserId != null && UserId == Uid) {
			for (Map<String, Object> response : userResponses) {
				String userAnswer = (String) response.get("userAnswer");
				String correctAnswer = (String) response.get("correctAnswer ");
				if (!userAnswer.equals(correctAnswer)) {
					correctAnswers++;
				}
			}
		}
//		String result = "Correct Answers: " + correctAnswers + ", Incorrect Answers: " + incorrectAnswers;
		double percent = ((double) correctAnswers / correctAnswers) * 100;
		String result = "Your Score is" + String.format("%.2f", percent) + "%";
		return ResponseEntity.ok(result);
	}
}
