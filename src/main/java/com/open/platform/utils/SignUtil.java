package com.open.platform.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SignUtil {
    public static String createSign(Map<String, Object> paramMap, String secretKey) {
        TreeMap<String, Object> treeMap = new TreeMap<>(paramMap);
        StringBuilder sb = new StringBuilder();
        treeMap.forEach((k, v) -> {
            if (!"sign".equals(k) && v != null && StrUtil.isNotBlank(v.toString())) {
                sb.append(k).append("=").append(v).append("&");
            }
        });
        sb.append("key=").append(secretKey);
        return SecureUtil.md5(sb.toString()).toUpperCase();
    }

    public static void main(String[] args) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("securityId", "TEST001");

        paramMap.put("timestamp", "1774617034045");
        paramMap.put("nonce", "abc123");

        System.out.println(createSign(paramMap, "7c428f96482a435f94c13f5f96b3f4a1"));
    }

}