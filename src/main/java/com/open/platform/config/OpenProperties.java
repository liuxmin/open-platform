package com.open.platform.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "open")
@Data
public class OpenProperties {

    /**
     * 接口访问有效时间
     */
    private Long effectiveTime;
}
