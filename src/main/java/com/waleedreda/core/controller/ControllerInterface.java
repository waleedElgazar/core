package com.waleedreda.core.controller;


import com.waleedreda.core.common.AppResponse;
import com.waleedreda.core.criteria.BaseCriteriaFilter;
import com.waleedreda.core.dto.BaseDto;

public interface ControllerInterface<D extends BaseDto, C extends BaseCriteriaFilter> {
    AppResponse<D> create(D dto);

    AppResponse<D> update(D dto);

    AppResponse<D> get(Long id);

    AppResponse<D> delete(Long id);

//    AppResponse<SearchResultDto<D>> find(C criteriaFilter);

}
