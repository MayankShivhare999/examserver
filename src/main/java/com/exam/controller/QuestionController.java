package com.exam.controller;

import com.exam.entites.exam.Question;
import com.exam.entites.exam.Quiz;
import com.exam.services.QuestionService;
import com.exam.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    //add question
    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //update question
    @PutMapping("/")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //get questions of quiz
    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid) {
        //Quiz quiz = new Quiz();
        Quiz quiz = this.quizService.getQuiz(qid);
        Set<Question> questions = quiz.getQuestions();
        List list = new ArrayList(questions);
        if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())) {
            list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    //get single question
    @GetMapping("/{questionId}")
    public Question get(@PathVariable("questionId") Long questionId) {
        return this.questionService.getQuestion(questionId);
    }

    //delete question
    @DeleteMapping("/{questionId")
    public void deleteQuestion(@PathVariable("questionId") Long questionId) {
        this.questionService.deleteQuestion(questionId);
    }

}
