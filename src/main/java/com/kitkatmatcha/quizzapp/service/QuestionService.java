package com.kitkatmatcha.quizzapp.service;

import com.kitkatmatcha.quizzapp.entity.*;

import java.util.*;

public interface QuestionService {
    List<Question> findAllQuestions();
    Question findById(Integer id);
    List<Question> findQuestionsByCategory(String category);
    Question saveQuestion(Question theQuestion);
    void deleteQuestionById(Integer id);
}
