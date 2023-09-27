package com.waleedreda.core.service;

import com.waleedreda.core.dto.BaseDto;
import com.waleedreda.core.entity.BaseEntity;
import com.waleedreda.core.mapper.BaseMapper;

public abstract class BaseService<D extends BaseDto, E extends BaseEntity> {
    public abstract BaseMapper<D,E> getMapper();

}
