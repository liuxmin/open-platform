package com.open.platform.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.open.platform.mapper.*")
public class ApplicationConfig {

    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return builder -> builder.timeZone("Asia/Shanghai");
    }

}
