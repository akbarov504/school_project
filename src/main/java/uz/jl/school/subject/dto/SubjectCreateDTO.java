package uz.jl.school.subject.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubjectCreateDTO {
    private String name;
    private String code;
    private String value;
}
