package uz.jl.school.file.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileGetDTO {
    private Long id;
    private Long size;
    private String originalName;
    private String generatedName;
    private String extension;
    private String url;
}
