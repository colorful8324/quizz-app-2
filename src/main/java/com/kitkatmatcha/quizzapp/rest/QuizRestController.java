package com.kitkatmatcha.quizzapp.rest;

import com.kitkatmatcha.quizzapp.entity.*;
import com.kitkatmatcha.quizzapp.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/quiz")
public class QuizRestController {
    private QuizServiceImpl quizServiceImpl;

    @Autowired
    public QuizRestController(QuizServiceImpl quizServiceImpl) {
        this.quizServiceImpl = quizServiceImpl;
    }

    @PostMapping
    public Quiz createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        return quizServiceImpl.createQuiz(category, numQ, title);
    }

    @GetMapping("/{id}")
    public List<QuestionWrapper> findQuizById(@PathVariable Integer id) {
        return quizServiceImpl.findQuizById(id);
    }

    @GetMapping("/submit/{quizId}")
    public Integer submitQuiz(@PathVariable Integer quizId, @RequestBody List<Response> response) {
        return quizServiceImpl.calculateMark(quizId, response);
    }
}
