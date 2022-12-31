package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/30
 * @Time: 18:54
 * @Description:
 * @Version:
 */
@SpringBootTest
public class MyBatisWrapperTest {
    @Resource
    UserMapper userMapper;

    @Test
    void test01(){
        /*
        * Preparing: SELECT uid AS id,is_deleted,name AS userName,age,email FROM t_user WHERE is_deleted=0
        * AND (name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        * */
        //查询用户名包含a且年龄在20-30之间且邮箱不为null
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name","a");
        queryWrapper.between("age",20,30);
        queryWrapper.isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    void test02(){
        //SELECT uid AS id,is_deleted,name AS userName,age,email FROM t_user
        // WHERE is_deleted=0 ORDER BY age DESC,uid ASC
        //查询用户信息，按照年龄降序排序，若年龄相同则按照id升序
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age");
        queryWrapper.orderByAsc("uid");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    void test03(){
        //删除邮箱地址为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result = userMapper.delete(queryWrapper);
        System.out.println("result="+result);
    }

    @Test
    void test04(){
        //UPDATE t_user SET name=?, email=? WHERE is_deleted=0
        // AND (age > ? AND name LIKE ? OR email IS NULL)
        //将年龄大于20且用户名中包含有a或者邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",20)
                .like("name","a")
                .or()
                .isNull("email");
        User user = new User();
        user.setUserName("小明");
        user.setEmail("test@atguigu.com");
        userMapper.update(user,queryWrapper);
        System.out.println(user);
    }

    @Test
    void test05(){
        //UPDATE t_user SET name=?, email=? WHERE is_deleted=0
        // AND (name LIKE ? AND (age > ? OR email IS NULL))
        //将用户名中包含a并且(年龄大于20或邮箱为null)的用户信息修改
        //Lambda中的条件表达式优先执行
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","a")
                .and(i->i.gt("age",20).or().isNull("email"));

        User user = new User();
        user.setUserName("丁真");
        user.setEmail("test@atguigu.com");
        userMapper.update(user,queryWrapper);
    }

    @Test
    void test07(){
        //查询用户的用户名、年龄、邮箱信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","age","email");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    void test08(){
        //queryWrapper用于实现子查询
        //SELECT uid AS id,is_deleted,name AS userName,age,email FROM t_user WHERE is_deleted=0
        // AND (uid IN (select uid from t_user where uid <= 100))
        //查询id小于等于100的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("uid","select uid  from t_user where uid <= 100");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    void test09(){
        //将用户名中包含a(年龄大于20或邮箱为null)的用户信息修改
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("name","a")
                .and(i->i.gt("age",20).or().isNull("email"));
        updateWrapper.set("name","小黑")
                .set("email","abc@atguigu.com");
        int result = userMapper.update(null, updateWrapper);
        System.out.println("result:"+result);
    }

    @Test
    void test10(){
        String username = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)){
            //isNotBlank判断某个字符串是否不为空字符串，不为null，部位空白符
            queryWrapper.like("name",username);
        }
        if (ageBegin != null){
            //大于
            queryWrapper.ge("age",ageBegin);
        }
        if (ageEnd != null){
            //小于
            queryWrapper.le("age",ageEnd);
        }
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    void test11(){
        String username = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username),"name","a")
                .ge(ageBegin!=null,"age",ageBegin)
                .le(ageEnd!=null,"age",ageEnd);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    void test12(){
        //SELECT uid AS id,is_deleted,name AS userName,age,email FROM t_user
        // WHERE is_deleted=0 AND (name LIKE ? AND age <= ?)
        String username = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username),User::getUserName,username)
                .ge(ageBegin !=null,User::getAge,ageBegin)
                .le(ageEnd !=null,User::getAge,ageEnd);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    void test13(){
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.like(User::getUserName,"a")
                .and(i->i.gt(User::getAge,20).or().isNull(User::getEmail));
        updateWrapper.set(User::getUserName,"小胖顶真");
        int result = userMapper.update(null, updateWrapper);

    }
}