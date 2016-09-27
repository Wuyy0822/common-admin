package com.panlingxiao.common_admin.web.tag;

import com.panlingxiao.common_admin.constant.Constant;
import com.panlingxiao.common_admin.domain.Resource;
import com.panlingxiao.common_admin.service.user.ResourceService;
import com.panlingxiao.common_admin.web.view.Config;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.panlingxiao.common_admin.web.tag.TagUtil.*;

/**
 * Created by panlingxiao on 2016/9/26.
 */
public class MenuTag extends SimpleTagSupport {

    public static final Logger log = LoggerFactory.getLogger(MenuTag.class);

    @Override
    public void doTag() throws JspException, IOException {
        // 得到代表jsp标签体的JspFragment
        JspFragment jspFragment = this.getJspBody();
        PageContext pageContext = (PageContext) this.getJspContext();
        ServletContext servletContext = pageContext.getServletContext();
        //通过ServletContext获取Spring容器
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        ResourceService resourceService = webApplicationContext.getBean(RESOURCE_SERVICE_NAME, ResourceService.class);
        //获取系统的资源菜单树
        Map<Integer, Resource> systemTreeResourceMap = resourceService.getSystemTreeResourceMap();
        Session session = SecurityUtils.getSubject().getSession();
        //获取用户具有的资源
        List<Resource> userResources = (List<Resource>) session.getAttribute(Constant.USER_RESOURCE);
        String content = Config.getDisplayStrategy().display(systemTreeResourceMap, userResources);
        if(log.isDebugEnabled()){
            log.debug("生成的菜单内容为\n:{}",content);
        }
        //将显示的菜单输出到浏览器中
        pageContext.getOut().write(content.toString());
    }








}
