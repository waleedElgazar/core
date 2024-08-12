//package com.fawry.corelibrary.controller;
//
//import com.waleedreda.core.common.AppResponse;
//import com.waleedreda.core.common.AppResponseUtil;
//import com.waleedreda.core.controller.ControllerInterface;
//import com.waleedreda.core.criteria.BaseCriteriaFilter;
//import com.waleedreda.core.dto.BaseDto;
//import org.springframework.validation.annotation.Validated;
//
//
//
//public abstract class BaseController<D extends BaseDto, C extends BaseCriteriaFilter> implements ControllerInterface<D, C> {
//
//    @PostMapping
//    @Override
//    public AppResponse<D> create(@Validated(CreateProfile.class) @RequestBody D dto) {
//        D createdDto = getService().create(dto);
//        return AppResponseUtil.buildSuccessResponse(createdDto);
//    }
//
//    @PutMapping
//    @Override
//    public AppResponse<D> update(@Validated(UpdateProfile.class) @RequestBody D dto) {
//        D updatedDto = getService().update(dto);
//        return AppResponseUtil.buildSuccessResponse(updatedDto);
//    }
//
//    @GetMapping(value = "/{id}")
//    @Override
//    public AppResponse<D> get(@PathVariable("id") Long id) {
//        D dto = getService().get(id);
//        return AppResponseUtil.buildSuccessResponse(dto);
//    }
//
//    @DeleteMapping(value = "/{id}")
//    @Override
//    public AppResponse<D> delete(@PathVariable("id") Long id) {
//        getService().delete(id);
//        return AppResponseUtil.buildSuccessResponse(null);
//    }
//
//    @PostMapping(value = "/find")
//    @Override
//    public AppResponse<SearchResultDto<D>> find(@Validated(FindProfile.class) @RequestBody C criteriaFilter) {
//        SearchResultDto<D> searchResultDto = getService().find(criteriaFilter);
//        return AppResponseUtil.buildSuccessResponse(searchResultDto);
//    }
//
//    @PostMapping(value = "/{customOperation}")
//    @Override
//    public AppResponse<Object> handleCustomOperation(@RequestBody String dto, @PathVariable("customOperation") CustomOperationEnum customOperation) throws JsonProcessingException {
//        Object data = getService().handleCustomOperation(dto, customOperation);
//        return AppResponseUtil.buildSuccessResponse(data);
//    }
//
////    public abstract ServiceInterface<D, C> getService();
//}
