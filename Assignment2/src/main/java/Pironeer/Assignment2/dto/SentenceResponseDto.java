package Pironeer.Assignment2.dto;

import Pironeer.Assignment2.model.Sentence;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SentenceResponseDto {
    private int length;
    private int wordCnt;
    private boolean containSpring;
}
