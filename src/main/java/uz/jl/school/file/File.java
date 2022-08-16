package uz.jl.school.file;

import lombok.*;
import uz.jl.school.base.Auditable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "file")
public class File extends Auditable {
    private Long size;
    private String originalName;
    private String generatedName;
    private String extension;
    private String path;
    private String url;
}
