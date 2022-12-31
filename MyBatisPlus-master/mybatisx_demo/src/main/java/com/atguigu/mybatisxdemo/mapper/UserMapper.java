package com.atguigu.mybatisxdemo.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;




import com.atguigu.mybatisxdemo.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Lizhixiang
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-12-31 21:37:49
* @Entity com,atguigu.mybatisx.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {

    int insertSelective(User user);

    int deleteByUid(@Param("uid") Long uid);

    int updateAgeAndSexByUid(@Param("age") Integer age, @Param("sex") Integer sex, @Param("uid") Long uid);

    List<User> selectAgeAndSexByAgeBetween(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);

    List<User> selectAllByAgeOrderByAgeDesc(@Param("age") Integer age);


}




