package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/28
 * @Time: 15:09
 * @Description:
 * @Version:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 返回值为Map时使用@MapKey注解指定map中key的属性
     * @param id
     * @return
     */
    @MapKey("name")
    Map<String,Object> selectMapById(Long id);


    /**
     * 通过年龄查询用户信息并分页
     * @param page MybatisPlus所提供的分页对象,必须位于第一个参数的位置
     * @param id
     * @return
     */
    Page<User> selectPageVo(@Param("page") Page<User>page,@Param("age") Integer id);
}