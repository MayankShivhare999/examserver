package com.exam.controller;

import com.exam.entites.exam.Category;
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

    //get category specific Quiz
    @GetMapping("/category/{cid}")
    public ResponseEntity<?> getQuizzesOfCategory(@PathVariable("cid") Long cid) {
        Category category = new Category();
        category.setCid(cid);
        return ResponseEntity.ok(this.quizService.getQuizzesOfCategory(category));
    }

    //get active quizzes
    @GetMapping("/active")
    public ResponseEntity<?> getActiveQuizzes() {
        return ResponseEntity.ok(this.quizService.getActiveQuizzes());
    }

    //get active quizzes of category
    @GetMapping("category/active/{cid}")
    public ResponseEntity<?> getActiveQuizzesByCategory(@PathVariable("cid") Long cid) {
        Category category = new Category();
        category.setCid(cid);
        return ResponseEntity.ok(this.quizService.getActiveQuizzesOfCategory(category));
    }
 }
