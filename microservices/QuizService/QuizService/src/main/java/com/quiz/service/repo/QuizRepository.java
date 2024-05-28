package com.quiz.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.service.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Long>{
	

}
