package com.example.mybatisplus;

import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/28
 * @Time: 15:13
 * @Description:
 * @Version:
 */
@SpringBootTest
public class MyBatisPlusTest {
    @Resource
    UserMapper userMapper;

    @Test
    void testSelectList(){
        //通过条件构造器查询一个list集合，若没有条件则可设置null为参数
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    //@RepeatedTest(value = 3)
    void testInserted(){
        //INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        User user = new User();
        user.setUserName("张三");
        user.setAge(23);
        user.setEmail("zhangsan@atguigu.com");
        int result = userMapper.insert(user);
        System.out.println("user:"+user);
        System.out.println("result:"+result);

    }


    @Test
    void testDelete(){
        //通过id删除用户信息
        //DELETE FROM user WHERE id=?
        int result = userMapper.deleteById(1L);
        System.out.println("result:"+result);
    }

    @Test
    void testDeleteByMap(){
        // 根据map集合中所封装的条件删除
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",23);
        int result = userMapper.deleteByMap(map);
        System.out.println("result="+result);
    }

    @Test
    void testDeleteByBatchIds(){
        /*
        *根据id组成的集合删除用户信息
        * delete ... id in(x,y,z)
        * */
        List<Long> ids = Arrays.asList(1608020189352337409L, 1608021244551208961L, 1608021245788528641L);
        int result = userMapper.deleteBatchIds(ids);
        System.out.println("result:"+result);
    }

    @Test
    void testUpdate(){
        //修改用户信息
        //UPDATE user SET name=?, email=? WHERE id=?
        User user = new User();
        user.setId(1608021245855637506L);
        user.setUserName("李四");
        user.setEmail("lisi@atguigu.com");
        int result = userMapper.updateById(user);
        System.out.println("result:"+result);
    }

    @Test
    void testSelect(){
        //通过id查询用户信息
        //SELECT id,name,age,email FROM user WHERE id=?
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    void testSelectBatchIds(){
        //根据id组成的集合批量查询用户信息
        //SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? , ? , ? )
        List<Long> ids = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        List<User> users = userMapper.selectBatchIds(ids);
        users.forEach(System.out::println);
    }

    @Test
    void testSelectByMap(){
        //根据map集合中的条件查询用户信息
        //ELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","Jack");
        map.put("age",20);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    void testSelectMapById(){
        Map<String, Object> map = userMapper.selectMapById(1608021245855637506L);
        System.out.println(map);
    }
}