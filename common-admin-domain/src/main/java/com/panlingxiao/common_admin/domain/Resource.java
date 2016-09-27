package com.panlingxiao.common_admin.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by panlingxiao on 2016/9/25.
 */
@Setter
@Getter
@ToString
public class Resource {

    /**
     * 资源ID
     */
    private Integer id;
    /**
     * 资源名称
     */
    private String name;
    /**
     *  资源类型
     */
    private ResourceType type = ResourceType.menu;
    /**
     * 资源路径
     */
    private String url;
    /**
     * 权限字符串
     */
    private String permission;
    /**
     *  父编号
     */
    private Integer parentId;

    /**
     * 父编号列表
     */
    private String parentIds;

    private Boolean available = Boolean.FALSE;

    private List<Resource> children;

    private Map<Integer,Resource> childrenNode;

    /**
     * 资源的级别,只针对菜单有效
     */
    private int level;

    /**
     * 菜单显示的顺序
     */
    private int position;

    /**
     * 资源对应的图标
     */
    private String icon;

    public void addChildren(Resource resource) {
        if(children == null){
            children = new ArrayList<>();
        }
        children.add(resource);
    }

    public void addChildNode(Resource resource){
        if(childrenNode == null){
           childrenNode =  new HashMap<>();
        }
        childrenNode.put(resource.getId(), resource);
    }

    public boolean hasChildNode(Resource resource) {
        if(children == null){
            return false;
        }
        return childrenNode.containsKey(resource.getId());
    }

    public static enum ResourceType {
        menu("菜单"), button("按钮");

        private final String info;
        private ResourceType(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }
    }

    /**
     * 判断当前菜单是否是一级菜单
     * @return
     */
    public boolean isFirstMenu(){
        return parentId == null || parentId <=0;
    }


}
