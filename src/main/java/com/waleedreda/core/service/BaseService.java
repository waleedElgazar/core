package com.waleedreda.core.service;


import com.waleedreda.core.common.AppResponse;
import com.waleedreda.core.common.AppResponseUtil;
import com.waleedreda.core.common.ErrorCode;
import com.waleedreda.core.criteria.BaseCriteriaFilter;
import com.waleedreda.core.dto.BaseDto;
import com.waleedreda.core.entity.BaseEntity;
import com.waleedreda.core.mapper.BaseMapper;
import com.waleedreda.core.repo.BaseRepo;

import java.util.List;
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

    public AppResponse<D> put(Long id, D dto) {
        if (null == id) {
            throw new RuntimeException("Id can't be null.");
        }
        Optional byId = getRepo().findById(id);
        if (null == byId){
            return AppResponseUtil.buildFailedResponse(ErrorCode.NOT_FOUND,"can't find record with this id " + id);
        }
        E oldEntity = (E) byId.get();
        E newEntity = (E) getMapper().convertToEntity(dto);
        doBeforeUpdate(oldEntity, newEntity);
        newEntity = (E) getRepo().save(newEntity);
        D newDto = (D) getMapper().convertToDto(newEntity);
        return AppResponseUtil.buildSuccessResponse(newDto);
    }

    public AppResponse<D> get(Long id){
        if (null == id){
            throw new RuntimeException("Id can't be null.");
        }
        Optional byId = getRepo().findById(id);
        if (null == byId){
            return AppResponseUtil.buildFailedResponse(ErrorCode.NOT_FOUND,"can't find record with this id " + id);
        }
        E e = (E) byId.get();
        D d = (D) getMapper().convertToDto(e);
        return AppResponseUtil.buildSuccessResponse(d);
    }

    public AppResponse<List<D>> getAll(){
        List<E> entityList = getRepo().findAll();
        List dtoList = getMapper().convertListEntityToDto(entityList);
        return AppResponseUtil.buildSuccessResponse(dtoList);
    }

    protected void doBeforeUpdate(E oldEntity, E newEntity){};
    protected Object doCustomOperation(String operationType, Object...objects){
        throw new UnsupportedOperationException();
    };
    public abstract BaseRepo getRepo();

    public abstract BaseMapper getMapper();
}
