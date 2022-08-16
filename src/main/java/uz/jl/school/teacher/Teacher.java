package uz.jl.school.teacher;

import lombok.*;
import org.hibernate.annotations.Where;
import uz.jl.school.base.Auditable;
import uz.jl.school.enums.SubjectEnum;
import uz.jl.school.file.File;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher")
@Where(clause = "is_deleted = false")
public class Teacher extends Auditable {
    private String fullName;
    @ManyToOne
    @JoinColumn(name = "image_id")
    private File image;
    private SubjectEnum subject;

    @Column(name = "about", nullable = false, columnDefinition = "TEXT")
    private String about;
}
