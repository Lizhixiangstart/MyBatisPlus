package com.example.mybatis_plus_datasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatis_plus_datasource.mapper.ProductMapper;
import com.example.mybatis_plus_datasource.pojo.Product;
import com.example.mybatis_plus_datasource.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/31
 * @Time: 20:39
 * @Description:
 * @Version:
 */
@Service
@DS("slave_1")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}