package com.e_job.QuestionAnswers.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.e_job.QuestionAnswers.Model.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

	@Query("SELECT q FROM Question q WHERE q.department.depart_id = :departId")
	List<Question> findQuestionsByDepartId(@Param("departId") int departId);
}
