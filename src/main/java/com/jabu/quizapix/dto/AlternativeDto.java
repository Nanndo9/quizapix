package com.jabu.quizapix.dto;

import com.jabu.quizapix.model.Alternatives;
import lombok.Builder;
import lombok.Data;
import org.w3c.dom.Text;
@Builder
@Data
public class AlternativeDto {
    private Integer id;
    private String text;

    public  static AlternativeDto convert(Alternatives alternative){
        return AlternativeDto.builder()
                .id(alternative.getId())
                .text(alternative.getText())
                .build();
    }

}
