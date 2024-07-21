package com.jabu.quizapix.dto;

import com.jabu.quizapix.model.Question;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionDto {
    private Integer id;
    private String text;
    private List<AlternativeDto> alternativeDtos;


    public static QuestionDto convert(Question question) {
        return QuestionDto.builder()
                .id(question.getId())
                .text(question.getText())
                .alternativeDtos(question.getAlternatives().stream().map(AlternativeDto::convert).toList())
                .build();
    }


}
