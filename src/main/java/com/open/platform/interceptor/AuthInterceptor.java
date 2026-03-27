package com.open.platform.interceptor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.open.platform.common.NoSign;
import com.open.platform.common.R;
import com.open.platform.config.OpenProperties;
import com.open.platform.domain.auth.OpenApp;
import com.open.platform.model.response.auth.OpenApiResponse;
import com.open.platform.service.auth.OpenAppService;
import com.open.platform.utils.IpUtil;
import com.open.platform.utils.SignUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Resource
    private OpenAppService openAppService;

    @Resource
    private OpenProperties openProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) return true;
        HandlerMethod method = (HandlerMethod) handler;
        if (method.hasMethodAnnotation(NoSign.class)) return true;

        String securityId = request.getHeader("securityId");
        String timestamp = request.getHeader("timestamp");
        String nonce = request.getHeader("nonce");
        String sign = request.getHeader("sign");

        if (StrUtil.isBlank(securityId) || StrUtil.isBlank(timestamp)
                || StrUtil.isBlank(nonce) || StrUtil.isBlank(sign)) {
            out(response, R.unauthorized("参数不完整"));
            return false;
        }

        if (System.currentTimeMillis() - Long.parseLong(timestamp) > openProperties.getEffectiveTime()) {
            System.out.println("sign = " + (System.currentTimeMillis() - Long.parseLong(timestamp)));
            out(response, R.unauthorized("请求已过期"));
            return false;
        }

        OpenApp app = openAppService.getBySecurityId(securityId);
        if (app == null) {
            out(response, R.unauthorized("securityId 不存在"));
            return false;
        }

        String ip = IpUtil.getIp(request);
        if (StrUtil.isNotBlank(app.getIpWhitelist()) && !app.getIpWhitelist().contains(ip)) {
            out(response, R.unauthorized("IP 不在白名单"));
            return false;
        }

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("securityId", securityId);
        paramMap.put("timestamp", timestamp);
        paramMap.put("nonce", nonce);
        String mySign = SignUtil.createSign(paramMap, app.getSecretKey());

        if (!sign.equals(mySign)) {
            out(response, R.unauthorized("签名错误"));
            return false;
        }

        return true;
    }

    private void out(HttpServletResponse response, R<?> r) {
        try {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(JSONUtil.toJsonStr(r));
        } catch (Exception ignored) {
        }
    }
}