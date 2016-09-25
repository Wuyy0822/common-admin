package com.panlingxiao.common_admin.controller;

import com.panlingxiao.common_admin.constant.Constant;
import com.panlingxiao.common_admin.message.request.user.UserRequest;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by panlingxiao on 2016/8/30.
 */
@Controller
public class LoginController {

    private static  final Logger log = LoggerFactory.getLogger(LoginController.class);
    /**
     * 显示表单登入页面
     *
     * @param userRequest
     * @return
     */
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String showLoginForm(@ModelAttribute("user") UserRequest userRequest) {
        return "login";
    }

    /**
     * 处理表单登入,这里已经和Shiro集成,在FormAuthenticationFilter进行认证失败后,会将异常信息认证到
     * HttpServletRequest中,所以这里处理的是针对认证失败后的进一步处理
     * @param userRequest
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") UserRequest userRequest, WebRequest webRequest,Model model) {
        String exception = (String) webRequest.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, RequestAttributes.SCOPE_REQUEST);
        if(exception != null) {
            log.warn("用户登入失败:{}", exception);
            model.addAttribute("error", "用户名或者密码错误");
            return "login";
        }else{
            return Constant.REDIRECT+"/";
        }
    }

}
