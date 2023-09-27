package com.waleedreda.core.mapper;


import com.waleedreda.core.dto.BaseDto;
import com.waleedreda.core.entity.BaseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public abstract class BaseMapper<D extends BaseDto, E extends BaseEntity> {

    @Autowired
    private ModelMapper modelMapper;


    public BaseMapper() {
    }

    public D ConvertToDto(E entity) {
        if (entity == null) {
            return null;
        } else {
            D dto = (D) this.modelMapper.map(entity, this.getDtoClass());
            return dto;
        }
    }

    public E ConvertToEntity(D dto) {
        if (dto == null) {
            return null;
        } else {
            E entity = (E) this.modelMapper.map(dto, this.getEntityClass());
            return entity;
        }
    }

    public abstract Class<D> getDtoClass();

    public abstract Class<E> getEntityClass();

}
