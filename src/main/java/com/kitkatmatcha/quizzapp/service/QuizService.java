package com.kitkatmatcha.quizzapp.service;

import com.kitkatmatcha.quizzapp.entity.*;

import java.util.*;

public interface QuizService {
    Quiz createQuiz(String category, int numQ, String title);
    List<QuestionWrapper> findQuizById(Integer id);
    Integer calculateMark(Integer quizId, List<Response> responseList);
}
