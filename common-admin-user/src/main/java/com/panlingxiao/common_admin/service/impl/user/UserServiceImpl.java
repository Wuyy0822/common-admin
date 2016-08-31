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
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by panlingxiao on 2016/8/30.
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> findUser(UserRequest userRequest) {
        /*
         * 由于前端传递的参数查询的偏移量和每页的大小
         * 这里需要重新计算这是第几页,通过Mybatis分页插件简化处理
         * 并且默认为第一页开始查询
         */
        PageHelper.startPage((userRequest.getStartIndex() / userRequest.getPageSize())+1, userRequest.getPageSize());
        Page<User> users = userMapper.findUser(userRequest);
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return pageInfo;
    }



    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}
