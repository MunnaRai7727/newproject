package com.question.service.que.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.question.service.entity.Question;

public interface QuestionRepo extends JpaRepository<Question,Long> {
	public List<Question> FindByquizId(Long quizId);

}
