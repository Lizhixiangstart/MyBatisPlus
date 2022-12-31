package com.example.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//扫描mapper接口，因此具体的mapper接口上可以不使用@Mapper注解
@MapperScan(basePackages = "com.example.mybatisplus.mapper")
public class MybatisPlusApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MybatisPlusApplication.class, args);

    }

}
