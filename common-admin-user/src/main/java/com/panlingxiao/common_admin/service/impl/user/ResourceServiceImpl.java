package com.panlingxiao.common_admin.service.impl.user;

import com.panlingxiao.common_admin.domain.Resource;
import com.panlingxiao.common_admin.mapper.user.ResourceMapper;
import com.panlingxiao.common_admin.service.user.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Collections;
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

    /**
     * 存储所有的资源到Map中，方便快速的根据ID来进行查找
     */
    private  Map<Integer, Resource> systemResourceMap;

    /**
     *  生成一个基于树状结构的Map,用户显示页面上的菜单
     */
    private   Map<Integer, Resource> systemTreeResourceMap;

    public static final Logger log = LoggerFactory.getLogger(ResourceServiceImpl.class);


    /**
     * 初始化系统资源
     */
    @PostConstruct
    public void initSystemResource(){
        long start = System.currentTimeMillis();
        loadResources();
        long end = System.currentTimeMillis();
        log.info("初始化系统资源成功,耗时{}秒",(end - start)/1000);
    }


    private void loadResources() {
        List<Resource> resources = resourceMapper.listAllMenuResource();
        HashMap<Integer,Resource> resourceMap= new HashMap<>();
        HashMap<Integer,Resource> treeResourceMap = new HashMap<>();
        for (Resource resource : resources) {
            resourceMap.put(resource.getId(), resource);
        }
        systemResourceMap = Collections.unmodifiableMap(resourceMap);

        for (Resource resource : resources) {
            Integer parentId = resource.getParentId();
            Integer id = resource.getId();
            Resource parent = null;
            //一级菜单
            if (parentId == null || parentId == 0) {
                //是否已经添加一级菜单
                if (!treeResourceMap.containsKey(id)) {
                    treeResourceMap.put(id, resource);
                }
            }else if (treeResourceMap.containsKey(parentId)) {  //判断当前菜单的父菜单是否存在
                parent = treeResourceMap.get(parentId);
                parent.addChildren(resource);
                //判断当前菜单的父菜单是否是一个一级菜单
            }else {
                putToMapRecursively(resource,treeResourceMap);
            }
        }
        systemTreeResourceMap = Collections.unmodifiableMap(treeResourceMap);
    }

    @Override
    public List<Resource> getMenuResourceTree() {
        return null;
    }

    /**
     * 递归获取当前菜单以及其父菜单添加
     * @param resource
     */
    private void putToMapRecursively(Resource resource,Map<Integer,Resource> treeResourceMap) {
        Integer parentId = resource.getParentId();
        Resource parent = systemResourceMap.get(parentId);
        if(parent.isFirstMenu()){
            treeResourceMap.put(parentId, parent);
            parent.addChildren(resource);
        }else{
            putToMapRecursively(parent,treeResourceMap);
            parent.addChildren(resource);
        }
    }

    public Map<Integer, Resource> getSystemResourceMap() {
        return systemResourceMap;
    }

    public Map<Integer, Resource> getSystemTreeResourceMap() {
        return systemTreeResourceMap;
    }
}
