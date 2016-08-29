package com.panlingxiao.common_admin.service.impl.user;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.panlingxiao.common_admin.domain.User;
import com.panlingxiao.common_admin.mapper.user.UserMapper;
import com.panlingxiao.common_admin.message.request.user.UserRequest;
import com.panlingxiao.common_admin.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by panlingxiao on 2016/8/30.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> findUser(UserRequest userRequest) {
        PageHelper.startPage(userRequest.getDraw(),userRequest.getPageSize());
        Page<User> users = userMapper.findUser(userRequest);

        PageInfo<User> pageInfo = new PageInfo<User>(users);
        pageInfo.setTotal(users.getTotal());
        pageInfo.setPages(users.getPages());
        pageInfo.setPageNum(users.getPageNum());
        return pageInfo;
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}
