package com.waleedreda.core.service;


import com.waleedreda.core.dto.BaseDto;
import com.waleedreda.core.entity.BaseEntity;
import com.waleedreda.core.mapper.BaseMapper;
import com.waleedreda.core.repo.BaseRepo;

import java.util.Optional;

public abstract class BaseService<E extends BaseEntity, D extends BaseDto> {

    public D add(D dtoObject) {
        E baseEntity = (E) getMapper().convertToEntity(dtoObject);
        E savedEntity = (E) getRepo().save(baseEntity);
        D baseDto = (D) getMapper().convertToDto(savedEntity);
        return baseDto;
    }

    public void delete(Long id) {
        if (null ==id){
            throw new RuntimeException("Id can't be null.");
        }
        getRepo().deleteById(id);
    }



    public abstract BaseRepo getRepo();

    public abstract BaseMapper getMapper();
}
