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

    /**
     * 根据用户Id查询用户的角色
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 用户登入
     * @param userRequest
     * @return
     */
    public User login(UserRequest userRequest);


}
