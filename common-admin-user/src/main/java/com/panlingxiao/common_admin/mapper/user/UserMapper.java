package com.panlingxiao.common_admin.mapper.user;

import com.github.pagehelper.Page;
import com.panlingxiao.common_admin.domain.User;
import com.panlingxiao.common_admin.message.request.user.UserRequest;

/**
 * Created by panlingxiao on 2016/8/29.
 */
public interface UserMapper {


    Page<User> findUser(UserRequest userRequest);

    void addUser(User user);

    int  deleteUser(Integer id);

    User getUserById(Integer id);

    User getUserByUserName(UserRequest userRequest);

    /**
     * 根据用户Id查询用户的角色和用户的权限
     * @param id
     */
    User getUserAuthorizationInfoById(Integer id);
}
