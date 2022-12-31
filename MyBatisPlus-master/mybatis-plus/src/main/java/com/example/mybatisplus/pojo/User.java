package com.example.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.example.mybatisplus.enums.SexEnum;
import lombok.*;
import org.springframework.stereotype.Repository;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/28
 * @Time: 15:03
 * @Description:
 * @Version:
 */
@Data
@Repository
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
//设置实体类所对应的表名
//@TableName("t_user")
public class User {
    //将此属性所对应的字段作为注解
    //IdType设置逐渐生成策略，默认使用 雪花算法生成主键
    @TableId(value = "uid",type = IdType.AUTO)
    private Long id;

    //逻辑删除，将is_deleted属性对应的字段交由mybatis-plus托管，0为逻辑存在，1为逻辑不存在
    @TableLogic
    private Integer isDeleted;
    //指定属性所对应的字段名
    @TableField("name")
    private String userName;

    private Integer age;

    private String email;

    private SexEnum sex;
}