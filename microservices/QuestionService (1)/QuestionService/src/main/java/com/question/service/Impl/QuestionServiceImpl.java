package com.question.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.question.service.entity.Question;
import com.question.service.que.repo.QuestionRepo;
import com.question.service.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	private QuestionRepo questionRepo;

	public QuestionServiceImpl(QuestionRepo questionRepo) {
		super();
		this.questionRepo = questionRepo;
	}

	@Override
	public Question createQuestion(Question question) {
		
		return this.questionRepo.save(question);
	}

	@Override
	public List<Question> getAll() {
		
		return this.questionRepo.findAll();
	}

	@Override
	public Question getById(Long id) {
		Question que=this.questionRepo.findById(id).orElseThrow(()-> new RuntimeException("Question  not found"));
		return que;
	}

	@Override
	public List<Question> getQuestionOfquiz(Long quizId) {
		
		return this.questionRepo.FindByquizId(quizId);
	}
      
}
