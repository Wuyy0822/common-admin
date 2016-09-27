package com.panlingxiao.common_admin.web.view;

import com.panlingxiao.common_admin.domain.Resource;

import java.util.List;
import java.util.Map;

/**
 * Created by panlingxiao on 2016/9/27.
 * 菜单显示策略
 */
public interface MenuDispalyStrategy {

    /**
     * 菜单显示
     * @param systemTreeResourceMap 资源
     * @param userResources
     */
    String display(Map<Integer, Resource> systemTreeResourceMap, List<Resource> userResources);
}
