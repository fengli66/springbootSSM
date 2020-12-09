package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户Controller类
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/userlist")
    @ResponseBody
    public List<User> getAllUsers() {
        List<User> userList = userService.findAll();
        if (userList != null && userList.size() > 0) {
            return userList;
        }
        return null;
    }

    @RequestMapping("/del")
    public String del(@Param("id") Integer id) {
        System.out.println("id" + id);
        int i = userService.delete(id);
        if (i > 0) {
            return "ok";
        }else {
            return "error";
        }
    }
}
