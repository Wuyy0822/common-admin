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

import static org.junit.Assert.assertEquals;

/**
 * Created by panlingxiao on 2016/8/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:user-service-test.xml")
public class UserServiceImplTest {

    @Autowired
    private UserService userService;


    @Test
    public void testAddUser() {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setUsername("hello:" + i);
            user.setPassword("pwd:" + i);
            user.setNickname("nickname:" + i);
            userService.addUser(user);
        }
    }


    /**
     * 参考PageHelper的单元测试
     */
    @Test
    public void testFindUser() {
        UserRequest userRequest = new UserRequest();

        //查询第一页数据
        userRequest.setStartIndex(0);
        userRequest.setPageSize(10);
        PageInfo<User> pageInfo = userService.findUser(userRequest);
        //当前页
        assertEquals(1, pageInfo.getPageNum());
        assertEquals(10, pageInfo.getPageSize());
        //当前查询集合中的第一个元素在数据库中的位置,从1开始算
        assertEquals(1, pageInfo.getStartRow());
        assertEquals(10, pageInfo.getEndRow());
        //总的数量
        assertEquals(100, pageInfo.getTotal());
        //总的页数
        assertEquals(10, pageInfo.getPages());
        assertEquals(1, pageInfo.getFirstPage());
        assertEquals(true, pageInfo.isIsFirstPage());
        assertEquals(false, pageInfo.isIsLastPage());
        assertEquals(false, pageInfo.isHasPreviousPage());
        assertEquals(true, pageInfo.isHasNextPage());



        //查询第二页数据
        userRequest.setStartIndex(10);
        userRequest.setPageSize(10);
        pageInfo = userService.findUser(userRequest);
        assertEquals(2, pageInfo.getPageNum());
        assertEquals(10, pageInfo.getPageSize());
        assertEquals(11, pageInfo.getStartRow());
        assertEquals(20, pageInfo.getEndRow());
        assertEquals(100, pageInfo.getTotal());
        assertEquals(10, pageInfo.getPages());
        assertEquals(1, pageInfo.getFirstPage());
        assertEquals(10, pageInfo.getPages());
        assertEquals(false, pageInfo.isIsFirstPage());
        assertEquals(false, pageInfo.isIsLastPage());
        assertEquals(true, pageInfo.isHasPreviousPage());
        assertEquals(true, pageInfo.isHasNextPage());


        userRequest.setStartIndex(90);
        userRequest.setPageSize(10);
        pageInfo = userService.findUser(userRequest);
        assertEquals(10, pageInfo.getPageNum());
        assertEquals(10, pageInfo.getPageSize());
        assertEquals(91, pageInfo.getStartRow());
        assertEquals(100, pageInfo.getEndRow());
        assertEquals(100, pageInfo.getTotal());
        assertEquals(10, pageInfo.getPages());
        assertEquals(false, pageInfo.isIsFirstPage());
        assertEquals(true, pageInfo.isIsLastPage());
        assertEquals(true, pageInfo.isHasPreviousPage());
        assertEquals(false, pageInfo.isHasNextPage());

    }

    @Test
    public void testFindUserByParam(){
        UserRequest userRequest = new UserRequest();
        userRequest.setStartIndex(0);
        userRequest.setPageSize(10);
        userRequest.setParam("hello:1");
        PageInfo<User> page = userService.findUser(userRequest);
        System.out.println(page.getList());

    }
}