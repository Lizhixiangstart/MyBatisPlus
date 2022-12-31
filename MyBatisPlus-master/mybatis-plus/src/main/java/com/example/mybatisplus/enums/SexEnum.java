package com.example.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/31
 * @Time: 17:59
 * @Description:
 * @Version:
 */
@Getter
@ToString
public enum SexEnum {

    MALE(1,"男"),
    FEAMLE(2,"女");



    @EnumValue//将注解所标识的属性值存储到数据库中
    private Integer sex;
    private String sexName;
    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}