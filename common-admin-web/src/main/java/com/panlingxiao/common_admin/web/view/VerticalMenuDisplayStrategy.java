package com.panlingxiao.common_admin.web.view;

import com.panlingxiao.common_admin.constant.Constant;
import com.panlingxiao.common_admin.domain.Resource;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import static com.panlingxiao.common_admin.web.tag.TagUtil.*;

/**
 * Created by panlingxiao on 2016/9/27.
 * 基于垂直方式显示菜单
 */
public class VerticalMenuDisplayStrategy implements MenuDispalyStrategy {

    private static final Logger log = LoggerFactory.getLogger(VerticalMenuDisplayStrategy.class);

    @Override
    public String display(Map<Integer, Resource> systemTreeResourceMap, List<Resource> userResources) {
        StringBuilder content = new StringBuilder();
        //开始菜单的标签
        content.append(MENU_START_TAG).append(LF);
        showMenu(systemTreeResourceMap,userResources,content);
        //结束菜单显示标签
        content.append(MENU_END_TAG).append(LF);
        return content.toString();
    }

    /**
     * 显示系统资源菜单
     * @return
     */
    private void showMenu(Map<Integer, Resource> systemTreeResourceMap, List<Resource> userResources,StringBuilder content) {
        if (systemTreeResourceMap != null) {
            for (Map.Entry<Integer, Resource> entry : systemTreeResourceMap.entrySet()) {
                Resource resource = entry.getValue();
                resource.getChildrenNode();
                boolean flag = false;
                flag = isDisplayMenu(userResources, resource, flag);
                if (flag) {
                    //获取当前资源的所子资源
                    Map<Integer, Resource> childrenNode = resource.getChildrenNode();
                    if (childrenNode != null && childrenNode.size() > 0) {
                        //显示一级菜单,当一级菜单下有子菜单时,一级菜单只显示内容
                        if (resource.getLevel() == Constant.FIRST_LEVEL) {
                            //显示一级菜单
                            startMenuTag(content, resource);
                            //显示一级菜单下的<dd><ul>
                            printDDAndULStartTag(content);
                            //显示一级菜单下的子菜单
                            showMenu(childrenNode, userResources,content);
                            //显示一级菜单下的</ul></dd>
                            printDDAndULEndTag(content);
                            endMenuTag(content);
                        } else {
                            //显示二级及以下的菜单
                            startLITag(content, resource);
                            printULStartTag(content);
                            showMenu(childrenNode, userResources, content);
                            printUlEndTag(content);
                            endLiTag(content);
                        }
                        //一级菜单下没有其余的子菜单,则一级菜单作为一个链接显示
                    }else if(resource.getLevel() == Constant.FIRST_LEVEL){
                        startTagWithLink(content, resource);
                        endMenuTag(content);
                    }else{
                        //二级及以下的菜单，如果没有子菜单则直接以li的方式显示链接
                        startLIAndLinkTag(content, resource);
                        endLiTag(content);
                    }
                }
            }
        }
    }



    /**
     * 是否显示菜单
     * @param userResources
     * @param resource
     * @param flag
     * @return
     */
    private boolean isDisplayMenu(List<Resource> userResources, Resource resource, boolean flag) {
        //根据用户的权限判断当前资源是否显示
        for (Resource userResource : userResources) {
            flag = checkPermission(userResource, resource);
            if (flag) {
                break;
            }
        }
        return flag;
    }

    /**
     * 根据用户具备的权限判断当前的资源菜单是否显示
     * @param userResource 用户所能访问的资源
     * @param resource 是否应该显示的资源
     */
    private boolean checkPermission(Resource userResource, Resource resource) {
        //根据用户所能访问的资源,判断当前的菜单资源是否显示
            WildcardPermission permission1 = new WildcardPermission(resource.getPermission());
            WildcardPermission permission2 = new WildcardPermission(userResource.getPermission());
            //根据Shiro的权限字符串来进行权限检测
            if (permission1.implies(permission2) || permission2.implies(permission1)) {
                return true;
            }
        return false;
    }
}
