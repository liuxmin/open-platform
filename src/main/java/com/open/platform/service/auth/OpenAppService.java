package com.open.platform.service.auth;

import com.open.platform.domain.auth.OpenApp;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Sojou
* @description 针对表【open_app(第三方应用表)】的数据库操作Service
* @createDate 2026-03-27 19:20:36
*/
public interface OpenAppService extends IService<OpenApp> {
    OpenApp getBySecurityId(String securityId);
}
