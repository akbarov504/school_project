package uz.jl.school.teacher.dto;

import lombok.*;
import uz.jl.school.enums.SubjectEnum;
import uz.jl.school.file.dto.FileGetDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeacherGetDTO {
    private String fullName;
    private FileGetDTO image;
    private SubjectEnum subject;
    private String about;
}
