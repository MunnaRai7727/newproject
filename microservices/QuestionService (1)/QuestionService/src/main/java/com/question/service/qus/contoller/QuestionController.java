package com.question.service.qus.contoller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.service.Impl.QuestionServiceImpl;
import com.question.service.entity.Question;

@RestController
@RequestMapping("/api")
public class QuestionController {
	  private QuestionServiceImpl questionServiceImpl;

	public QuestionController(QuestionServiceImpl questionServiceImpl) {
		super();
		this.questionServiceImpl = questionServiceImpl;
	}
    @PostMapping("/create")
	public ResponseEntity<Question> add(@RequestBody Question question){
		    Question que=   this.questionServiceImpl.createQuestion(question);
		return new ResponseEntity<Question>(que,HttpStatus.CREATED);
	}
    @GetMapping("/get")
	public List<Question>getAll(){
		return this.questionServiceImpl.getAll();
	}
    @GetMapping("/{Id}")
	public Question getById(@RequestBody @PathVariable Long Id) {
		Question que=this.questionServiceImpl.getById(Id);
		return que;
		
	}
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionquiz(@RequestBody @PathVariable Long quizId){
    	return this.questionServiceImpl.getQuestionOfquiz(quizId);
    	
    }
}
