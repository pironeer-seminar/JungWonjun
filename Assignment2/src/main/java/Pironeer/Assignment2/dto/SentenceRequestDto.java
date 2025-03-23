package Pironeer.Assignment2.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SentenceRequestDto {
    @NotBlank(message = "문장은 필수 입력 값입니다.")
    private String sentence;
}