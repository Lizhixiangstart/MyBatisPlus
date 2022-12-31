package com.example.mybatisplus;

import com.example.mybatisplus.pojo.User;
import com.example.mybatisplus.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/28
 * @Time: 22:24
 * @Description:
 * @Version:
 */
@SpringBootTest
public class MyBatisPlusServiceTest {
    @Resource
    UserServiceImpl userService;

    @Test
    void testGetCount(){
        /*
           获取数量
        * SELECT COUNT( * ) FROM user
        */
        int count = userService.count();
        System.out.println("总记录数:"+count);
    }

    @Test
    void testInsertMore(){
        //INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? ),说明每条数据都要单独执行一次插入语句
        User u1 = new User();
        u1.setUserName("小胖");
        u1.setAge(20);
        u1.setEmail("xiaopang@atguigu.com");

        User u2 = new User();
        u2.setUserName("万礼");
        u2.setAge(20);
        u2.setEmail("wanli@atguigu.com");
        List<User> users = Arrays.asList(u1, u2);
        boolean result = userService.saveBatch(users);
        for (User u : users){
            System.out.println(u);
        }
        System.out.println("result:"+result);
    }


}