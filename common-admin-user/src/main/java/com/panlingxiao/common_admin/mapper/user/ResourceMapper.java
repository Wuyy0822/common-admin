package com.panlingxiao.common_admin.mapper.user;

import com.panlingxiao.common_admin.domain.Resource;

import java.util.List;

/**
 * Created by panlingxiao on 2016/9/26.
 */
public interface ResourceMapper {

    /**
     * 查询所有的菜单资源
     * @return
     */
    List<Resource> listAllMenuResource();
}
