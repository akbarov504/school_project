package uz.jl.school.news.dto;

import lombok.*;
import uz.jl.school.file.dto.FileGetDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewsGetDTO {
    private Integer id;
    private String title;
    private String description;
    private FileGetDTO image;
    private String body;
}
