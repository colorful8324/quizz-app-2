package com.kitkatmatcha.quizzapp.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * A question without correct answer, used for fetching to client
 * @author kitkatmatcha
 */
@Data
@AllArgsConstructor
public class QuestionWrapper {
    private Integer id;
    @Column(name = "question_title")
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    @Column(name = "difficulty_level")
    private String difficultyLevel;
    private String category;
}
