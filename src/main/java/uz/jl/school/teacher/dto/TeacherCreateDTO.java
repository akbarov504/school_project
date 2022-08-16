package uz.jl.school.teacher.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import uz.jl.school.enums.SubjectEnum;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeacherCreateDTO {
    private String fullName;
    private MultipartFile image;
    private SubjectEnum subject;
    private String about;
}
