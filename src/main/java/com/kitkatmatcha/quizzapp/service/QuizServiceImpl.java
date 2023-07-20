package com.kitkatmatcha.quizzapp.service;

import com.kitkatmatcha.quizzapp.entity.*;
import com.kitkatmatcha.quizzapp.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class QuizServiceImpl implements QuizService {
    private QuizRepository quizRepository;
    private QuestionRepository questionRepository;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public Quiz createQuiz(String category, int numQ, String title) {
        List<Question> questionList = questionRepository.findRandomQuestionsByCategory(category, numQ);

        Quiz tempQuiz = new Quiz();
        tempQuiz.setTitle(title);
        tempQuiz.setQuestions(questionList);
        quizRepository.save(tempQuiz);

        return tempQuiz;
    }

    @Override
    public List<QuestionWrapper> findQuizById(Integer id) {
        Optional<Quiz> tempQuiz = quizRepository.findById(id);
        List<Question> questionList = tempQuiz.get().getQuestions();
        List<QuestionWrapper> theQuestionWrapperList = new ArrayList<>();
        for (Question tempQuestion : questionList) {
            QuestionWrapper qw = new QuestionWrapper(tempQuestion.getId(),
                    tempQuestion.getQuestionTitle(),
                    tempQuestion.getOption1(),
                    tempQuestion.getOption2(),
                    tempQuestion.getOption3(),
                    tempQuestion.getOption4(),
                    tempQuestion.getDifficultyLevel(),
                    tempQuestion.getCategory()
            );
            theQuestionWrapperList.add(qw);
        }

        return theQuestionWrapperList;
    }

    @Override
    public Integer calculateMark(Integer quizId, List<Response> responseList) {
        Quiz quiz = quizRepository.findById(quizId).get();
        List<Question> questionList = quiz.getQuestions();
        class sortById implements Comparator<Response> {
            @Override
            public int compare(Response o1, Response o2) {
                return o1.getId() - o2.getId();
            }
        }
        responseList.sort(new sortById());
        int correct = 0;
        for (int i = 0; i < responseList.size(); i++) {
            // if user's answer matches correct answer
            if (responseList.get(i).getUserAnswer().equals(questionList.get(i).getCorrectAnswer())) {
                correct++;
            }
        }

        return correct;
    }
}
