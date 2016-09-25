package com.panlingxiao.common_admin.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    private Long parentId;

    /**
     * 父编号列表
     */
    private String parentIds;

    private Boolean available = Boolean.FALSE;

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


}
