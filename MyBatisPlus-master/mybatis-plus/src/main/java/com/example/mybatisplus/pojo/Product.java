package com.example.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/31
 * @Time: 16:29
 * @Description:
 * @Version:
 */
@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version//标识乐观锁版本号字段
    private Integer version;
}