package com.quiz.service.quizcontroler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.service.entity.Quiz;
import com.quiz.service.services.impl.QuizImplServices;

@RestController
@RequestMapping("/api")
public class QuizController {
	   private QuizImplServices quizImplServices;

	public QuizController(QuizImplServices quizImplServices) {
		super();
		this.quizImplServices = quizImplServices;
	}
	    @PostMapping("/add")
	   public ResponseEntity<Quiz> create(@RequestBody Quiz quiz){
		 Quiz s=  this.quizImplServices.add(quiz);
		   return new ResponseEntity<Quiz>(s,HttpStatus.CREATED);
		   
	   }
	    @GetMapping("/get")
	  public List<Quiz> get(){
		  return this.quizImplServices.getAll();
		  
	  }
	    @GetMapping("/{Id}")
      public Quiz getbyId(@PathVariable Long Id) {
    	  return this.quizImplServices.get(Id);
    	  
      }
}
