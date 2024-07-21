package com.jabu.quizapix.controller;

import com.jabu.quizapix.dto.AlternativeDto;
import com.jabu.quizapix.dto.QuestionDto;
import com.jabu.quizapix.model.Alternatives;
import com.jabu.quizapix.model.Question;
import com.jabu.quizapix.repository.AlternativeRepository;
import com.jabu.quizapix.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AlternativeRepository alternativesRepository;

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        Question savedQuestion = questionRepository.save(question);

        List<Alternatives> alternatives = question.getAlternatives();
        for (Alternatives alternative : alternatives) {
            alternative.setQuestion(savedQuestion);
            alternativesRepository.save(alternative);
        }

        return savedQuestion;
    }
    @GetMapping
    public  List<QuestionDto>getQuestion(){
        return questionRepository.findAll().stream().map(QuestionDto::convert).toList();
    }

    @GetMapping("/correct/alternative/{id}")
    public AlternativeDto getCorrectAlternative(@PathVariable Integer id){
        return AlternativeDto.convert(alternativesRepository.findCorrectAlternative(id));
    }
}