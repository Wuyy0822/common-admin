package com.panlingxiao.common_admin.service.impl.user;

import com.github.pagehelper.PageInfo;
import com.panlingxiao.common_admin.domain.User;
import com.panlingxiao.common_admin.message.request.user.UserRequest;
import com.panlingxiao.common_admin.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by panlingxiao on 2016/8/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:user-service-test.xml")
public class UserServiceImplTest {

    @Autowired
    private UserService userService;


    @Test
    public void testAddUser(){
        for(int i = 0;i < 100;i++) {
            User user = new User();
            user.setUsername("hello:"+i);
            user.setPassword("pwd:" + i);
            user.setNickname("nickname:"+i);
            userService.addUser(user);
        }
    }

    @Test
    public void testFindUser(){
        UserRequest userRequest = new UserRequest();
        PageInfo<User> pageInfo = userService.findUser(userRequest);
        System.out.println(pageInfo);
    }
}