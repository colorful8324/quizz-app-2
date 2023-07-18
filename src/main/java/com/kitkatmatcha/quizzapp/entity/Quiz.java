package com.kitkatmatcha.quizzapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ManyToMany
    private List<Question> questions;
}
