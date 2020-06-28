package com.murong.controller;

import com.murong.domain.User;
import com.murong.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MybatisController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/query")
    @ResponseBody
    public List<User> queryUserList(){
        List<User> users= userMapper.queryUserList();
        return users;
    }
    @RequestMapping("/update")
    public void updateUser(){
        User user = new User();
         user.setId(2);
         user.setUsername("zhangsansan");
         user.setPassword("12233");
         user.setName("张三三");
         userMapper.updateUser(user);
    }


}
