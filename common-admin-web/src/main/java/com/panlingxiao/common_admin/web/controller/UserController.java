package com.panlingxiao.common_admin.web.controller;

import com.github.pagehelper.PageInfo;
import com.panlingxiao.common_admin.domain.User;
import com.panlingxiao.common_admin.message.request.user.UserRequest;
import com.panlingxiao.common_admin.service.user.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by panlingxiao on 2016/8/30.
 */
@RequestMapping("/user")
@Controller
@SessionAttributes("userRequest")
public class UserController {

    public static final String USER_REQUEST = "userRequest";

    @Autowired
    private UserService userService;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @ModelAttribute
    public void init(Model model) {
        if (!model.containsAttribute(USER_REQUEST)) {
            model.addAttribute(USER_REQUEST, new UserRequest());
        }
    }


    /**
     *
     * @param refresh
     * @param model
     * @param userRequest
     * @return
     */
    @RequestMapping(value = "/list/view")
    @RequiresPermissions("user:list:view")
    public String manage(boolean refresh, Model model, @ModelAttribute(USER_REQUEST) UserRequest userRequest) {
        if (!refresh) {
            model.addAttribute(USER_REQUEST, new UserRequest());
        }
        return "user/user-manage";
    }

    /**
     * @param request
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Map<String, Object> list(@ModelAttribute(USER_REQUEST) UserRequest request) {
        if (log.isDebugEnabled()) {
            log.debug(" 用户请求参数:{}", request);
        }
        PageInfo<User> pageInfo = userService.findUser(request);
        HashMap<String, Object> map = new HashMap<>();
        map.put("pageData", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        //map.put("draw", pageInfo.getPageNum());
        return map;
    }


}
