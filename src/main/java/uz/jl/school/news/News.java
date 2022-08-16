package uz.jl.school.news;

import lombok.*;
import org.hibernate.annotations.Where;
import uz.jl.school.base.Auditable;
import uz.jl.school.file.File;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "news")
@Where(clause = "is_deleted = false")
public class News extends Auditable {
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "image_id")
    private File image;
    @Column(name = "body", nullable = false, columnDefinition = "TEXT")
    private String body;
}
