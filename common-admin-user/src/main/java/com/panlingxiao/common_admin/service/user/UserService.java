package com.panlingxiao.common_admin.service.user;

import com.github.pagehelper.PageInfo;
import com.panlingxiao.common_admin.domain.User;
import com.panlingxiao.common_admin.message.request.user.UserRequest;

/**
 * Created by panlingxiao on 2016/8/29.
 */
public interface UserService {

    PageInfo<User> findUser(UserRequest userRequest);


    void addUser(User user);


}
