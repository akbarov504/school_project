package uz.jl.school.base;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractService<R extends BaseRepository> implements BaseService {
    protected final R repository;
}
