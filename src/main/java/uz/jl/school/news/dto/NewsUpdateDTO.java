package uz.jl.school.news.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewsUpdateDTO {
    private Integer id;
    private String title;
    private String description;
    private MultipartFile image;
    private String body;
}
