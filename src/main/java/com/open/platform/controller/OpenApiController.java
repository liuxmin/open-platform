package com.open.platform.controller;

import com.open.platform.common.NoSign;
import com.open.platform.common.R;
import com.open.platform.model.request.auth.OpenApiRequest;
import com.open.platform.model.response.auth.OpenApiResponse;
import com.open.platform.service.auth.OpenAppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Api(value = "三方开放接口",tags = {"三方开放接口"})
public class OpenApiController {

    @GetMapping("/data")
    @ApiOperation("三方开放接口数据测试")
    @NoSign
    public R<OpenApiResponse> getData(@Valid @ModelAttribute OpenApiRequest req) {
        OpenApiResponse response = new OpenApiResponse();
        response.setId(req.getId());
        response.setName(req.getName());
        return R.ok(response);
    }
}