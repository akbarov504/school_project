package uz.jl.school.teacher;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.jl.school.base.BaseMapper;

@Component
@Mapper(componentModel = "spring")
public interface TeacherMapper extends BaseMapper {
}
