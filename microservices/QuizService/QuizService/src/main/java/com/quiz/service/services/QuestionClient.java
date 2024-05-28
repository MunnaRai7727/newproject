package com.quiz.service.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.service.entity.Question;

@FeignClient(url="http://localhost:8080",value="Question-Client")
public interface QuestionClient {
	    @GetMapping("/get{quizId}")
	  List<Question> questionOfQuiz(@PathVariable Long quizId);
	   
}
