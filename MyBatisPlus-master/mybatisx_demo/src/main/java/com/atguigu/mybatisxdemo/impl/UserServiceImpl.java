package com.atguigu.mybatisxdemo.impl;

import com.atguigu.mybatisxdemo.UserService;
import com.atguigu.mybatisxdemo.mapper.UserMapper;
import com.atguigu.mybatisxdemo.pojo.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author Lizhixiang
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-12-31 21:37:49
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

}




