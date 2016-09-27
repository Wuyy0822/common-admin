package com.panlingxiao.common_admin.service.impl.user;

import com.panlingxiao.common_admin.domain.Resource;
import com.panlingxiao.common_admin.service.user.ResourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by panlingxiao on 2016/9/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:user-service-test.xml")
public class ResourceServiceTest {

    @Autowired
    private ResourceService resourceService;

    @Test
    public void testListAllResource() {
        resourceService.getMenuResourceTree();
    }

    @Test
    public void testSystemResource() {
        Map<Integer, Resource> systemResourceMap = resourceService.getSystemResourceMap();
        for (Map.Entry<Integer, Resource> entry : systemResourceMap.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
    }

    @Test
    public void testSystemTreeResource() {
        Map<Integer, Resource> systemResourceMap = resourceService.getSystemTreeResourceMap();
        for (Map.Entry<Integer, Resource> entry : systemResourceMap.entrySet()) {
            Resource resource = entry.getValue();
            System.out.println(resource.getName()+","+resource.getId()+","+resource.getPermission());
            printChildren(resource.getChildrenNode().values(), 2);
        }
    }

    private void printChildren(Collection<Resource> resourcces, int n) {
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "\t";
        }
        for (Resource resource : resourcces) {
            System.out.println(str + resource.getName() + "," + resource.getId()+","+resource.getPermission());
            if(resource.getChildrenNode() != null) {
                Collection<Resource> children =resource.getChildrenNode().values();
                if (children != null && !children.isEmpty()) {
                    printChildren(children, n + 1);
                }
            }
        }
    }

    /**
     * 根据用户Id获取所有资源
     */
    @Test
    public void testListResourceByUserId(){
        List<Resource> resources = resourceService.listResourceByUserId(1);
        System.out.println(resources);
    }
}
