package com.open.platform.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> R<T> ok(T data) {
        return new R<>(ResultCode.SUCCESS, "success", data);
    }

    public static <T> R<T> error(String msg) {
        return new R<>(ResultCode.ERROR, msg, null);
    }

    public static <T> R<T> unauthorized(String msg) {
        return new R<>(ResultCode.NO_AUTH, msg, null);
    }
}