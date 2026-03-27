package com.open.platform.service.auth.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.open.platform.domain.auth.OpenApp;
import com.open.platform.mapper.auth.OpenAppMapper;
import com.open.platform.service.auth.OpenAppService;
import org.springframework.stereotype.Service;

/**
 * @author Sojou
 * @description 针对表【open_app(第三方应用表)】的数据库操作Service实现
 * @createDate 2026-03-27 19:20:36
 */
@Service
public class OpenAppServiceImpl extends ServiceImpl<OpenAppMapper, OpenApp>
        implements OpenAppService {
    @Override
    public OpenApp getBySecurityId(String securityId) {
        return this.getOne(new LambdaQueryWrapper<OpenApp>()
                .eq(OpenApp::getSecurityId, securityId)
                .eq(OpenApp::getStatus, 1));
    }

}




