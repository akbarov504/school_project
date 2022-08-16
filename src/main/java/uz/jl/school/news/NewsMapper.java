package uz.jl.school.news;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.jl.school.base.BaseMapper;

@Component
@Mapper(componentModel = "spring")
public interface NewsMapper extends BaseMapper {

}
