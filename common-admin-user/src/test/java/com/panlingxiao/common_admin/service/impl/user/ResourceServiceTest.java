package com.panlingxiao.common_admin.service.impl.user;

import com.panlingxiao.common_admin.service.user.ResourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by panlingxiao on 2016/9/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:user-service-test.xml")
public class ResourceServiceTest {

    @Autowired
    private ResourceService resourceService;

    @Test
    public void testListAllResource(){
        resourceService.getMenuResourceTree();
    }
}
