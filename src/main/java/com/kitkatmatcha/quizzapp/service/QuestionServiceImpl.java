package com.kitkatmatcha.quizzapp.service;

import com.kitkatmatcha.quizzapp.entity.*;
import com.kitkatmatcha.quizzapp.repository.*;
import com.kitkatmatcha.quizzapp.rest.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {
    QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> findAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question findById(Integer id) {
        Optional<Question> result = questionRepository.findById(id);
        Question theQuestion = null;
        if (result.isPresent()) {
            theQuestion = result.get();
        }
        else {
            throw new QuestionNotFoundException("Question not found - " + id);
        }
        return theQuestion;
    }

    @Override
    public List<Question> findQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    @Override
    public Question saveQuestion(Question theQuestion) {
        return questionRepository.save(theQuestion);
    }

    @Override
    public void deleteQuestionById(Integer id) {
        questionRepository.deleteById(id);
    }

}
