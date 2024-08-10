package com.waleedreda.core.mapper;


import com.waleedreda.core.dto.BaseDto;
import com.waleedreda.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@Component
public abstract class BaseMapper<E extends BaseEntity, D extends BaseDto> {

    private ModelMapper modelMapper;

    public BaseMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public E convertToEntity(D dto) {
        if (null == dto) {
            return null;
        }
        return this.getModelMapper().map(dto, this.getEntityClass());
    }

    public D convertToDto(E entity) {
        if (null == entity) {
            return null;
        }
        return this.getModelMapper().map(entity, this.getDtoClass());
    }

    public List<D> convertListEntityToDto(List<E> entityList) {
        List<D> dtoList = new ArrayList<>();
        for (E entity : entityList) {
            dtoList.add(convertToDto(entity));
        }
        return dtoList;
    }

    public List<E> convertListDtoToEntity(List<D> dtoList) {
        List<E> entityList = new ArrayList<>();
        for (D dto : dtoList) {
            entityList.add(convertToEntity(dto));
        }
        return entityList;
    }


    public abstract Class<D> getDtoClass();

    public abstract Class<E> getEntityClass();
}
