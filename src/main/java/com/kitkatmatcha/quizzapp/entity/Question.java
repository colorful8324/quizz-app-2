package com.kitkatmatcha.quizzapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "question_title")
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    @Column(name = "correct_answer")
    private String correctAnswer;
    @Column(name = "difficulty_level")
    private String difficultyLevel;
    private String category;

    public Question(String questionTitle, String option1, String option2, String option3, String option4, String correctAnswer, String difficultyLevel, String category) {
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
        this.difficultyLevel = difficultyLevel;
        this.category = category;
    }

    public Question() {
    }
}
