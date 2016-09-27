package com.panlingxiao.common_admin.web.controller;

import com.panlingxiao.common_admin.constant.Constant;
import com.panlingxiao.common_admin.domain.Resource;
import com.panlingxiao.common_admin.message.request.user.UserRequest;
import com.panlingxiao.common_admin.service.user.ResourceService;
import com.panlingxiao.common_admin.web.bind.annotation.CurrentUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by panlingxiao on 2016/9/25.
 */
@Controller
public class IndexController {

    @Autowired
    private ResourceService resourceService;
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);


    @RequestMapping("/")
    public String index(@CurrentUser UserRequest userRequest) {
        Session session = SecurityUtils.getSubject().getSession();
        if(null == session.getAttribute(Constant.USER_RESOURCE)) {
            List<Resource> resources = resourceService.listResourceByUserId(userRequest.getId());
            if(log.isDebugEnabled()){
                log.debug("用户{}所具有的资源:",userRequest.getUsername());
                for(Resource resource : resources){
                    log.debug("{}",resource);
                }
            }
            session.setAttribute(Constant.USER_RESOURCE,resources);
        }
        return "index";
    }

}
