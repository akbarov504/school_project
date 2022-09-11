package uz.jl.school.subject;

import lombok.*;
import org.hibernate.annotations.Where;
import uz.jl.school.base.Auditable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subject")
@Where(clause = "is_deleted = false")
public class Subject extends Auditable {
    private String name;
    private String code;
    private String description;
}
