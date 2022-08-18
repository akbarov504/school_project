package uz.jl.school.subject.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubjectUpdateDTO {
    private Integer id;
    private String name;
    private String code;
    private String value;
}
