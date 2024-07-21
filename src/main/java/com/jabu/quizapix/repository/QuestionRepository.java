package com.jabu.quizapix.repository;

import com.jabu.quizapix.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
}
