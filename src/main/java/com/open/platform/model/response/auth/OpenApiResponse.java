package com.open.platform.model.response.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@ApiModel("测试出参")
@Data
public class OpenApiResponse {

    @ApiModelProperty(value = "主键",required = true)
    @NotEmpty(message = "主键入参不能为空")
    private Long id;

    @ApiModelProperty(value = "名称",required = true)
    @NotEmpty(message = "名称入参不能为空")
    private String name;
}
