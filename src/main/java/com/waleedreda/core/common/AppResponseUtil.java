package com.waleedreda.core.common;

public class AppResponseUtil {
    private AppResponseUtil() {
    }

    public static AppResponse buildSuccessResponse() {
        return new AppResponse(StatusEnum.SUCCESS, (Object) null, (String) null, (String) null);
    }

    public static <D> AppResponse<D> buildSuccessResponse(D data) {
        return new AppResponse(StatusEnum.SUCCESS, data, (String) null, (String) null);
    }

    public static <D> AppResponse<D> buildFailedResponse(ErrorCode errorCode, String appErrorDto) {
        return new AppResponse(StatusEnum.FAILED, (Object) null, errorCode.toString(), appErrorDto);
    }
}