package com.jabu.quizapix.repository;

import com.jabu.quizapix.model.Alternatives;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlternativeRepository extends JpaRepository<Alternatives,Integer> {
    @Query("SELECT a FROM Alternatives a WHERE a.question.id = :id AND a.isCorrect = true")
  Alternatives findCorrectAlternative(Integer id);
}
