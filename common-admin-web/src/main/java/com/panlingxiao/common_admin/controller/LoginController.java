package com.panlingxiao.common_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by panlingxiao on 2016/8/30.
 */
@Controller
public class LoginController {


    @RequestMapping(value={"/","/login"},method = RequestMethod.GET)
    public String login(){
        return "main";
    }
}
