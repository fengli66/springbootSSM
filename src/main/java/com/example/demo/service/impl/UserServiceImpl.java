package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.awt.SunHints;

import javax.annotation.Resource;
import java.util.List;

/**
 * service层接口实现类
 *
 * @author fengli
 * @version 1.0
 * @date 2020/12/08
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    @Cacheable(value = "UserCache",key = "'user.findAll'")
    public List<User> findAll() {
        List<User> userList = userMapper.findAll();
        if (userList != null && userList.size() > 0) {
            return userList;
        }
        return null;
    }

    @Override
    @CacheEvict(value = "UserCache",key = "'user.findAll'")
    public int delete(Integer id) {
        int flag=0;
        try {
            userMapper.delete(id);
            flag=1;
        }catch (Exception e){

        }
        return flag;
    }
}
