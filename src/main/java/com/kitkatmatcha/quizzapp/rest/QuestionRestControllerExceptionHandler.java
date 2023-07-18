package com.kitkatmatcha.quizzapp.rest;

import com.kitkatmatcha.quizzapp.entity.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class QuestionRestControllerExceptionHandler {
    @ExceptionHandler({CategoryNotFoundException.class, QuestionNotFoundException.class})
    public ResponseEntity<QuestionErrorResponse> handleEntityException(Exception exc) {
        QuestionErrorResponse error = new QuestionErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<QuestionErrorResponse> handleUnwantedException(Exception exc) {
        QuestionErrorResponse error = new QuestionErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
