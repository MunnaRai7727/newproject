package com.question.service.service;

import java.util.List;

import com.question.service.entity.Question;

public interface QuestionService {
	    public Question createQuestion(Question question);
	     public List<Question>getAll();
	     Question getById(Long id);
	     List<Question> getQuestionOfquiz(Long quizId);

}
