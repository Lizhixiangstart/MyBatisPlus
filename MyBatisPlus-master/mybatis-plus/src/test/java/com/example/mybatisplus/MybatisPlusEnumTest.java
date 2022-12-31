package com.example.mybatisplus;

import com.example.mybatisplus.enums.SexEnum;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/31
 * @Time: 17:52
 * @Description:
 * @Version:
 */
@SpringBootTest
public class MybatisPlusEnumTest {
    @Resource
    UserMapper userMapper;

    @Test
    void test(){
        User user = new User();
        user.setUserName("admin");
        user.setAge(33);
        user.setSex(SexEnum.MALE);
        int result = userMapper.insert(user);
        System.out.println("result:"+result);
    }

    @Test
    void testGet(){
        User user = userMapper.selectById(16084100228727L);
        System.out.println(user.getSex());
    }
}