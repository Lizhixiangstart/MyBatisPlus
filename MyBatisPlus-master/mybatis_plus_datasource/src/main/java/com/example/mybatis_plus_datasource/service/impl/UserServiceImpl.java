package com.example.mybatis_plus_datasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatis_plus_datasource.mapper.UserMapper;
import com.example.mybatis_plus_datasource.pojo.User;
import com.example.mybatis_plus_datasource.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/31
 * @Time: 20:36
 * @Description:
 * @Version:
 */
@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}