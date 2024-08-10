package com.waleedreda.core.service;


import com.waleedreda.core.dto.BaseDto;
import com.waleedreda.core.entity.BaseEntity;
import com.waleedreda.core.mapper.BaseMapper;
import com.waleedreda.core.repo.BaseRepo;

public abstract class BaseService<E extends BaseEntity, D extends BaseDto> {

    public D add(D dtoObject) {
        E baseEntity = (E) getMapper().convertToEntity(dtoObject);
        E savedEntity = (E) getRepo().save(baseEntity);
        D baseDto = (D) getMapper().convertToDto(savedEntity);
        return baseDto;
    }

    public void delete(D dtoObject) {
        E baseEntity = (E) getMapper().convertToEntity(dtoObject);
        getRepo().delete(baseEntity);
    }



    public abstract BaseRepo getRepo();

    public abstract BaseMapper getMapper();
}
