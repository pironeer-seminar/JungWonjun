package Pironeer.Assignment2.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sentence {
    private String sentence;
    private int length;
    private int wordCnt;
    private boolean containSpring;

    public Sentence(String sentence, int length, int wordCnt, boolean containSpring) {
        this.sentence = sentence;
        this.length = length;
        this.wordCnt = wordCnt;
        this.containSpring = containSpring;
    }
}
