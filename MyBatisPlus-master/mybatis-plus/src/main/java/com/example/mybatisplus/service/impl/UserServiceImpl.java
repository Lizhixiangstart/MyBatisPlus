package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import com.example.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/28
 * @Time: 23:09
 * @Description:
 * @Version:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}