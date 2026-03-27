package com.open.platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class Knife4jConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.open.platform.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("你的项目名称 - API文档") // 文档标题
                .description("基于Knife4j的接口调试文档，支持在线调试、参数说明") // 描述
                .version("1.0.0") // 版本
                .contact(new Contact("开发人员", "https://xxx.com", "xxx@xxx.com")) // 联系人
                .license("MIT License") // 许可证
                .licenseUrl("https://opensource.org/licenses/MIT")
                .build();
    }
}