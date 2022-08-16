package uz.jl.school.news;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.jl.school.base.BaseRepository;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer>, BaseRepository {
}
