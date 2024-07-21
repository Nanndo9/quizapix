package com.jabu.quizapix.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "alternatives")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alternatives {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String text;
    @ManyToOne
    @JoinColumn(name = "fk_question")
    @JsonIgnore
    private Question question;
    private boolean isCorrect;
}
