package com.ccb.mahm.web.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableSwagger2
@ComponentScan(basePackages = {"com.ccb.mahm.*"})
@MapperScan("com.ccb.mahm.core.dao")
public class ProviderApplication extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ProviderApplication.class);
        Map<String, Object> defProperties =  new HashMap<>();
        defProperties.put("spring.profiles.active", "dev");
        app.setDefaultProperties(defProperties);
        app.run(args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProviderApplication.class);
    }





}
