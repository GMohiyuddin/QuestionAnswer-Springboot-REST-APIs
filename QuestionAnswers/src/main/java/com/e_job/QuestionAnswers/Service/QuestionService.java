package com.e_job.QuestionAnswers.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_job.QuestionAnswers.Model.Question;
import com.e_job.QuestionAnswers.Repo.QuestionRepo;

@Service
public class QuestionService {

	@Autowired
	QuestionRepo Qrepo;

	public Question addquestion(Question que) {
		return Qrepo.save(que);
	}

	public List<Question> getQuestionByDId(int depart_id) {
		// TODO Auto-generated method stub
		return Qrepo.findQuestionsByDepartId(depart_id);
	}

	

}
