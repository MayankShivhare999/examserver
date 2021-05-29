package com.exam.controller;

import com.exam.entites.exam.Quiz;
import com.exam.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    //add quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    //update quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    //get quizes
    @GetMapping("/")
    public ResponseEntity<?> getQuizes() {
        return ResponseEntity.ok(this.quizService.getQuizes());
    }

    //get quiz
    @GetMapping("/{qid}")
    public ResponseEntity<?> getQuiz(@PathVariable("qid") Long qid) {
        return ResponseEntity.ok(this.quizService.getQuiz(qid));
    }

    //delete quiz
    @DeleteMapping("/{qid}")
    public void deleteQuiz(@PathVariable("qid") Long qid){
        this.quizService.deleteQuiz(qid);
    }
 }
