package uz.jl.school.base;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractService<M extends BaseMapper, R extends BaseRepository> implements BaseService {
    protected final M mapper;
    protected final R repository;
}
