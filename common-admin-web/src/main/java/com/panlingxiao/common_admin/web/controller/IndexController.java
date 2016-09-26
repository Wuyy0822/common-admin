package com.panlingxiao.common_admin.web.controller;

import com.panlingxiao.common_admin.message.request.user.UserRequest;
import com.panlingxiao.common_admin.service.user.UserService;
import com.panlingxiao.common_admin.web.bind.annotation.CurrentUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by panlingxiao on 2016/9/25.
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(@CurrentUser UserRequest userRequest) {
        Session session = SecurityUtils.getSubject().getSession();
        //判断是否用权限
        userService.getUserAuthorizationInfo(userRequest);
        return "index";
    }

}
