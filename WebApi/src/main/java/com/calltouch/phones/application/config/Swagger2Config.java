package com.calltouch.phones.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Created by morgan on 31.05.2020
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.calltouch.phones.web.controller"))
                .paths(PathSelectors.ant("/com/calltouch/phones/*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Phones REST API",
                "Mockup of API.",
                "API TOS",
                "Terms of service",
                new Contact("D. Goryachev", "www.calltouch.net", "info@calltouch.net"),
                "GPL v3", "API license URL", Collections.emptyList());
    }
}
