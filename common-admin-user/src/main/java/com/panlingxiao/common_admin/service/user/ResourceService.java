package com.panlingxiao.common_admin.service.user;

import com.panlingxiao.common_admin.domain.Resource;

import java.util.List;
import java.util.Map;

/**
 * Created by panlingxiao on 2016/9/26.
 */
public interface ResourceService {

    /**
     * 查询所有的资源,生成资源树
     * @return
     */
    public List<Resource> getMenuResourceTree();

    /**
     * 返回系统的所有资源，包括按钮
     * @return 返回的Map是一个只读的Map,不能修改
     */
    Map<Integer, Resource> getSystemResourceMap();

    /**
     * 基于树状结构返回系统的所有菜单资源
     * @return 返回的Map是一个只读的Map,不能修改
     */
    Map<Integer, Resource> getSystemTreeResourceMap();
}
