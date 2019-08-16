package com.yyk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 此处加上@EnableSwagger2注解 才能使用swagger
 * 加上@EnableCaching 使用redis
 */
@SpringBootApplication
@MapperScan({ "com.yyk.dao"})
@EnableCaching
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

