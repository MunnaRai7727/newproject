package com.quiz.service.services;

import java.util.List;

import com.quiz.service.entity.Quiz;

public interface QuizServices {
	    public Quiz add(Quiz quiz);
	    List<Quiz>getAll();
	    public Quiz get(Long quizId);
	    

}
