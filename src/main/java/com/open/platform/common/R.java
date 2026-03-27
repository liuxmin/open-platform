package com.open.platform.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("响应结果")
public class R<T> {
    @ApiModelProperty("状态码")
    private int code;

    @ApiModelProperty("提示信息")
    private String msg;

    @ApiModelProperty("响应数据")
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