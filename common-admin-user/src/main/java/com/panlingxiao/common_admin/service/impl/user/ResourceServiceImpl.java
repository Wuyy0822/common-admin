package com.panlingxiao.common_admin.service.impl.user;

import com.panlingxiao.common_admin.domain.Resource;
import com.panlingxiao.common_admin.mapper.user.ResourceMapper;
import com.panlingxiao.common_admin.service.user.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by panlingxiao on 2016/9/26.
 */
@Transactional
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public List<Resource> getMenuResourceTree() {
        List<Resource> resources = resourceMapper.listAllMenuResource();
        Map<Integer, Resource> resourceMap = new HashMap<>();
        for (Resource resource : resources) {
            resourceMap.put(resource.getId(), resource);
        }
        Map<Integer, Resource> treeResourceMap = new HashMap<>();
        for (Resource resource : resources) {
            Integer parentId = resource.getParentId();
            Integer id = resource.getId();
            Resource parent = null;
            if (parentId == null || parentId <= 0) {
                parent = treeResourceMap.get(id);
                if (parent == null) {
                    treeResourceMap.put(id, resource);
                } else if (treeResourceMap.containsKey(parentId)) {
                    parent = treeResourceMap.get(parentId);
                    parent.addChildren(resource);
                }else{

                }

            }
        }
        return null;
    }
}
