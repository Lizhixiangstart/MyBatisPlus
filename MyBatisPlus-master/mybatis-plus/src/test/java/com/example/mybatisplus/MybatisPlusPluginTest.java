package com.example.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.mapper.ProductMapper;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.Product;
import com.example.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/30
 * @Time: 21:32
 * @Description:
 * @Version:
 */
@SpringBootTest
public class MybatisPlusPluginTest {
    @Resource
    UserMapper userMapper;

    @Resource
    ProductMapper productMapper;

    @Test
    void test1(){
        Page<User> page = new Page<>(2,3);
        userMapper.selectPage(page,null);
        //Records总条数
        System.out.println(page.getRecords());
        //当前页码
        System.out.println(page.getCurrent());

        System.out.println(page.getPages());

        System.out.println(page.getTotal());

        System.out.println(page.hasNext());

        System.out.println(page.hasPrevious());
    }

    @Test
    void testPageVo(){
        //select uid,name,age,email from t_user where age > ? LIMIT ?
        Page<User> page = new Page<>(1,3);
        userMapper.selectPageVo(page,20);

        //Records总条数
        System.out.println(page.getRecords());
        //当前页码
        System.out.println(page.getCurrent());

        System.out.println(page.getPages());

        System.out.println(page.getTotal());

        System.out.println(page.hasNext());

        System.out.println(page.hasPrevious());
    }

    @Test
    void testProduct01(){
        //小李查询商品价格
        Product productLi = productMapper.selectById(1L);
        System.out.println("小李查询的商品信息："+productLi.getPrice());
        //小王查询商品信息
        Product productWang = productMapper.selectById(1L);
        System.out.println("小王查询的商品信息："+productWang.getPrice());
        //小李将商品价格+50
        productLi.setPrice(productLi.getPrice()+50);
        productMapper.updateById(productLi);
        //小王将商品价格-30
        productWang.setPrice(productWang.getPrice()-30);
        int result = productMapper.updateById(productWang);
        if (result==0){
            //操作失败，重试
            Product productNew = productMapper.selectById(1L);
            productNew.setPrice(productNew.getPrice()-30);
            productMapper.updateById(productNew);
        }

        //老板查询商品价格
        Product productLaoBan = productMapper.selectById(1L);
        System.out.println("老板查询商品价格："+productLaoBan.getPrice());

    }
}