package com.kitkatmatcha.quizzapp.repository;

import com.kitkatmatcha.quizzapp.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);
    @Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY rand() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);

}
