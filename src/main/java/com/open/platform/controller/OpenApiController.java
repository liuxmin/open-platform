package com.open.platform.controller;

import com.open.platform.common.R;
import com.open.platform.service.auth.OpenAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class OpenApiController {

    @Resource
    private OpenAppService openAppService;

    @GetMapping("/data")
    public R<Map<String, Object>> getData() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "第三方授权接口调用成功");
        map.put("data", "企业业务数据");
        return R.ok(map);
    }
}