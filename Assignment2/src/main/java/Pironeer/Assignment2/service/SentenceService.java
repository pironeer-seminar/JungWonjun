package Pironeer.Assignment2.service;

import Pironeer.Assignment2.dto.SentenceRequestDto;
import Pironeer.Assignment2.dto.SentenceResponseDto;
import Pironeer.Assignment2.model.Sentence;
import org.springframework.stereotype.Service;

@Service
public class SentenceService {
    // Response 로직
    public SentenceResponseDto getResult(SentenceRequestDto requestDto) {
        int length = requestDto.getSentence().length();
        String[] ls = requestDto.getSentence().split(" ");
        int wordCnt = ls.length;
        boolean containSpring = requestDto.getSentence().toLowerCase().contains("spring");

        return new SentenceResponseDto(length, wordCnt, containSpring);
    }
}
