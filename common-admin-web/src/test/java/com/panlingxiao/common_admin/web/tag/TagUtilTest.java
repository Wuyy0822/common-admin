package com.panlingxiao.common_admin.web.tag;

import com.panlingxiao.common_admin.domain.Resource;
import org.junit.Test;

/**
 * Created by panlingxiao on 2016/9/27.
 */
public class TagUtilTest {

    @Test
    public void testPrintDtTag() throws Exception {
        Resource resource = new Resource();
        resource.setName("系统管理");
        StringBuilder content = new StringBuilder();
        TagUtil.startMenuTag(content, resource);
        System.out.println(content);

    }

    @org.junit.Test
    public void testPrintDtTagWithLink() throws Exception {
        Resource resource = new Resource();
        resource.setName("系统管理");
        StringBuilder content = new StringBuilder();
        TagUtil.startTagWithLink(content, resource);
        System.out.println(content);
    }


    @Test
    public void testPrintDDAndULTag(){
        StringBuilder content = new StringBuilder();
        TagUtil.printDDAndULStartTag(content);
        TagUtil.printDDAndULEndTag(content);
        System.out.println(content);
    }
}