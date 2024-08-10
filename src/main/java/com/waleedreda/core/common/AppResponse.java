package com.waleedreda.core.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppResponse<T> {
    private StatusEnum status;
    private T data;
    private String errorCode;
    private String errorMessage;

    @Override
    public String toString() {
        return "AppResponse{" +
                "status=" + status +
                ", data=" + data +
                ", errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }

    public String toJsonString() {
        return "{\"data\":\"" + data + "\"" +
                ", \"status\":\"" + status + "\"," +
                " \"errorCode\":\"" + errorCode + "\"," +
                " \"errorMessage\":\"" + errorMessage + "\"}";
    }
}
