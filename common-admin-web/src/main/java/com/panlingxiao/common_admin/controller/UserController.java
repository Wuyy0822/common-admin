package com.panlingxiao.common_admin.controller;

import com.github.pagehelper.PageInfo;
import com.panlingxiao.common_admin.domain.User;
import com.panlingxiao.common_admin.message.request.user.UserRequest;
import com.panlingxiao.common_admin.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by panlingxiao on 2016/8/30.
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value="/manage",method = RequestMethod.GET)
    public String manage(){
        return "user/user-manage";
    }


    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> list(UserRequest request){
        PageInfo<User> pageInfo = userService.findUser(request);
        HashMap<String, Object> map = new HashMap<>();
        map.put("pageData", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        map.put("draw", pageInfo.getPageNum());
        return map;
    }



}
