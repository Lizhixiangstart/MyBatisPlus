package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/31
 * @Time: 16:31
 * @Description:
 * @Version:
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
