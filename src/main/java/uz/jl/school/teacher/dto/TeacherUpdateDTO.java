package uz.jl.school.teacher.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeacherUpdateDTO {
    private Integer id;
    private String fullName;
    private MultipartFile image;
    private String subject;
    private String about;
}
