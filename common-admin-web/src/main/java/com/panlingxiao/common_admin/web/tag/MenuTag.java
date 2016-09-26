package com.panlingxiao.common_admin.web.tag;

import com.panlingxiao.common_admin.domain.Resource;
import com.panlingxiao.common_admin.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

/**
 * Created by panlingxiao on 2016/9/26.
 */
public class MenuTag extends TagSupport{

    private static final String LI_URL_PATTERN = "\"<li><a %s data-title=%s href=\"%s\">%s</a></li>";

    @Override
    public int doStartTag() throws JspException {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        return super.doStartTag();
    }

    public void recursiveResource(List<Resource> resources){
        for(Resource resource : resources){
            //判断是否是一级
            //显示dl
            recursiveResource(resource.getChildren());
            //如果是2级
            if(resource.getUrl() == null){

            }else{
                String str = "<li><a _href=\"member-del.html\" data-title=\"删除的用户\" href=\"javascript:;\">角色管理</a></li>";
            }
        }

    }
}
