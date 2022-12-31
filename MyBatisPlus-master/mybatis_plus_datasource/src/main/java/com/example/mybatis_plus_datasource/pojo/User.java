package com.example.mybatis_plus_datasource.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/31
 * @Time: 20:29
 * @Description:
 * @Version:
 */
@Data
@TableName("t_user")
public class User {
    @TableId
    private Long uid;
    private String name;
    private Integer age;
    private String email;
    @TableLogic
    private Integer isDeleted;
    private Integer sex;
}