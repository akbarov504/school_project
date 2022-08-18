package uz.jl.school.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.jl.school.base.BaseRepository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>, BaseRepository {
    Optional<Subject> findByCode(String subject);
}
