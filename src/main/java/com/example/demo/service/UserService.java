package com.example.demo.service;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

/**
 * service层接口
 * @author fengli
 * @version 1.0
 * @date 2020/12/08
 */
public interface UserService {
    /**
     * 查询所有
     * @return
     */
    List<User> findAll();
    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    int delete(Integer id);
}
