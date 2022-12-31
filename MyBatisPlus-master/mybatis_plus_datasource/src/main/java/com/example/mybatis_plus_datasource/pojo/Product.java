package com.example.mybatis_plus_datasource.pojo;

import lombok.Data;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/31
 * @Time: 20:33
 * @Description:
 * @Version:
 */
@Data
public class Product {
    private Integer id;
    private String name;
    private Integer price;
    private Integer version;
}