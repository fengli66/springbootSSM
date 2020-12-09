package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * Mapper层接口
 * @author fengli
 * @version 1.0
 * @date 2020/12/08
 */
@Mapper
public interface UserMapper {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_user")
    List<User> findAll();

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @Delete("delete from tb_user where id = #{id}")
    void delete(Integer id);
}
