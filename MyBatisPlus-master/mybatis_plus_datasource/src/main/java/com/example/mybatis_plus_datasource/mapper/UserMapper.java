package com.example.mybatis_plus_datasource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis_plus_datasource.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/31
 * @Time: 20:34
 * @Description:
 * @Version:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
