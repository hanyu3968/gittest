package com.murong;

import com.murong.domain.User;
import com.murong.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class MybatisTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test(){
        List<User> users = userMapper.queryUserList();
        System.out.println("==========================");
        System.out.println(users);
    }
}
