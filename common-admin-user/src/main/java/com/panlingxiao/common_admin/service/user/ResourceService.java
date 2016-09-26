package com.panlingxiao.common_admin.service.user;

import com.panlingxiao.common_admin.domain.Resource;

import java.util.List;

/**
 * Created by panlingxiao on 2016/9/26.
 */
public interface ResourceService {

    /**
     * 查询所有的资源,生成资源树
     * @return
     */
    public List<Resource> getMenuResourceTree();

}
