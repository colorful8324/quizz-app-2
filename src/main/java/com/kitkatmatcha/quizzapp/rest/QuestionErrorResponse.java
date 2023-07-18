package com.kitkatmatcha.quizzapp.rest;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestionErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
