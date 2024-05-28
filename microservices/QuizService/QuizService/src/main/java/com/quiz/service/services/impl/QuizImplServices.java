package com.quiz.service.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.service.entity.Quiz;
import com.quiz.service.exp.ResourceNotFoundException;
import com.quiz.service.repo.QuizRepository;
import com.quiz.service.services.QuestionClient;
import com.quiz.service.services.QuizServices;

@Service
public class QuizImplServices implements QuizServices{
	@Autowired
   private QuizRepository  quizRepository;
//   
//	public QuizImplServices(QuizRepository quizRepository) {
//	super();
//	this.quizRepository = quizRepository;
//}      
	      @Autowired
         private QuestionClient questionClient;
	@Override
	public Quiz add(Quiz quiz) {
		
		return this.quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> getAll() {
		List<Quiz>quizzes=quizRepository.findAll();
		List<Quiz>quizlist=quizzes.stream().map(quiz->{ quiz.setQuestions(questionClient.questionOfQuiz(quiz.getQuizId()));
		return quiz;
		}).collect(Collectors.toList());
		return quizlist;
	}

	@Override
	public Quiz get(Long quizId) {
		
		Quiz quiz=quizRepository.findById(quizId).orElseThrow(()->new ResourceNotFoundException("Quiz is not found"));
		quiz.setQuestions(questionClient.questionOfQuiz(quiz.getQuizId()));
		return quiz;
	}
	

}
