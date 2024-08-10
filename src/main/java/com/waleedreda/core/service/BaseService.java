package com.waleedreda.core.service;


import com.waleedreda.core.common.AppResponse;
import com.waleedreda.core.common.AppResponseUtil;
import com.waleedreda.core.dto.BaseDto;
import com.waleedreda.core.entity.BaseEntity;
import com.waleedreda.core.mapper.BaseMapper;
import com.waleedreda.core.repo.BaseRepo;

import java.util.Optional;

public abstract class BaseService<E extends BaseEntity, D extends BaseDto> {

    public AppResponse<D> add(D dtoObject) {
        E baseEntity = (E) getMapper().convertToEntity(dtoObject);
        E savedEntity = (E) getRepo().save(baseEntity);
        D baseDto = (D) getMapper().convertToDto(savedEntity);
        return AppResponseUtil.buildSuccessResponse(baseDto);
    }

    public AppResponse<D> delete(Long id) {
        if (null ==id){
            throw new RuntimeException("Id can't be null.");
        }
        getRepo().deleteById(id);
        return AppResponseUtil.buildSuccessResponse();
    }



    public abstract BaseRepo getRepo();

    public abstract BaseMapper getMapper();
}
