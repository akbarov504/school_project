package uz.jl.school.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.jl.school.base.BaseRepository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>, BaseRepository {
}
