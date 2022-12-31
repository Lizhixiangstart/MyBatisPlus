package com.example.mybatis_plus_datasource;

import com.example.mybatis_plus_datasource.service.ProductService;
import com.example.mybatis_plus_datasource.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MybatisPlusDatasourceApplicationTests {

    @Resource
    UserService userService;
    
    @Resource
    ProductService productService;
    @Test
    void contextLoads() {
    }
    
    @Test
    void test(){
        System.out.println(userService.getById(1));
        System.out.println(productService.getById(1));
    }

}
