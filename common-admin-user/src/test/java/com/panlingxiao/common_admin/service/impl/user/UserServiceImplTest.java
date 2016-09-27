package com.panlingxiao.common_admin.service.impl.user;

import com.github.pagehelper.PageInfo;
import com.panlingxiao.common_admin.domain.Role;
import com.panlingxiao.common_admin.domain.User;
import com.panlingxiao.common_admin.message.request.user.UserRequest;
import com.panlingxiao.common_admin.service.user.UserService;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Set;

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
        User user = new User();
        user.setUsername("zs");
        user.setNickname("张三");
        user.setPassword("123");
        user.setRoleIds(Arrays.asList(1, 2, 3));
        userService.addUser(user);
    }

    @Test
    public void testPassword() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(2);
        UsernamePasswordToken token = new UsernamePasswordToken("zs", "123");
        User user = userService.getUserById(5);
        System.out.println(user.getSalt());
        boolean result =hashedCredentialsMatcher.doCredentialsMatch(token, new SimpleAuthenticationInfo("zs", user.getPassword(), ByteSource.Util.bytes(user.getUsername() + user.getSalt()), "abc"));
        System.out.println(result);
    }

    /**
     * 根据用户Id查询用户
     */
    @Test
    public void testGetUserById() {
        User user = userService.getUserById(2);
        System.out.println(user.getRoleIds());
    }

    @Test
    public void testGetUserByUserName() {
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("zs");
        User user = userService.login(userRequest);
        System.out.println(user.getRoleIds());
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
    public void testFindUserByParam() {
        UserRequest userRequest = new UserRequest();
        userRequest.setStartIndex(0);
        userRequest.setPageSize(10);
        userRequest.setParam("hello:1");
        PageInfo<User> page = userService.findUser(userRequest);
        System.out.println(page.getList());

    }
}