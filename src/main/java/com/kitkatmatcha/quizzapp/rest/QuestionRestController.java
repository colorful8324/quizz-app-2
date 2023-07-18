package com.kitkatmatcha.quizzapp.rest;

import com.kitkatmatcha.quizzapp.service.*;
import com.kitkatmatcha.quizzapp.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
public class QuestionRestController {
    QuestionServiceImpl questionServiceImpl;

    @Autowired
    public QuestionRestController(QuestionServiceImpl questionServiceImpl) {
        this.questionServiceImpl = questionServiceImpl;
    }

    @GetMapping
    public List<Question> findAllQuestions() {
        return questionServiceImpl.findAllQuestions();
    }

    @GetMapping(("/{id}"))
    public Question findQuestionById(@PathVariable Integer id) {
        Question tempQuestion = questionServiceImpl.findById(id);
        if (tempQuestion == null) {
            // just for clear context
            // this maybe unnecessary cause we already had this checked at service layer
            throw new QuestionNotFoundException("Question id not found - " + id);
        }
        return tempQuestion;
    }

    @GetMapping("/category/{theCategory}")
    public List<Question> findQuestionsByCategory(@PathVariable String theCategory) {
        if (questionServiceImpl.findQuestionsByCategory(theCategory).isEmpty()) {
            throw new CategoryNotFoundException("Category not found - " + theCategory);
        }
        return questionServiceImpl.findQuestionsByCategory(theCategory);
    }

    @PostMapping
    public Question addQuestion(@RequestBody Question theQuestion) {
        theQuestion.setId(0);
        return questionServiceImpl.saveQuestion(theQuestion);
    }

    @PutMapping
    public Question updateQuestion(@RequestBody Question theQuestion) {
        return questionServiceImpl.saveQuestion(theQuestion);
    }

    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable Integer id) {
        Question tempQuestion = questionServiceImpl.findById(id);
        if (tempQuestion == null) {
            // just for clear context
            // this maybe unnecessary cause we already had this checked at service layer
            throw new QuestionNotFoundException("Question id not found - " + id);
        }
        questionServiceImpl.deleteQuestionById(id);
        return "Deleted question id - " + id;
    }
}
