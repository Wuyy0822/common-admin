package com.panlingxiao.common_admin.web.view;

import com.panlingxiao.common_admin.domain.Resource;
import com.panlingxiao.common_admin.service.user.ResourceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by panlingxiao on 2016/9/27.
 */
@ContextConfiguration(locations = "classpath:spring-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class VerticalMenuDisplayStrategyTest {

    private MenuDispalyStrategy menuDispalyStrategy = new VerticalMenuDisplayStrategy();

    @Autowired
    private ResourceService resourceService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testDisplay() throws Exception {
        Map<Integer, Resource> systemTreeResourceMap = resourceService.getSystemTreeResourceMap();
        List<Resource> resources = resourceService.listResourceByUserId(1);
        resources.clear();
        Resource resource = new Resource();
        resource.setPermission("*");
        resources.add(resource);
        String content = menuDispalyStrategy.display(systemTreeResourceMap, resources);
        System.out.println(content);
    }
}