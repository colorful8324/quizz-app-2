package com.kitkatmatcha.quizzapp.repository;

import com.kitkatmatcha.quizzapp.entity.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
