package com.panlingxiao.common_admin.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by panlingxiao on 2016/9/25.
 */
@Setter
@Getter
@ToString
public class Role {
    /**
     * 角色ID
     */
    private Integer id;
    /**
     * 角色标识 程序中判断使用,如"admin"
     */
    private String name;
    /**
     * 角色描述,UI界面显示使用
     */
    private String description;
    /**
     * 拥有的资源
     */
    private List<Long> resourceIds;
    /**
     * 是否可用,如果不可用将不会添加给用户
     */
    private Boolean available = Boolean.FALSE;

    /**
     * 具体的资源
     */
    private List<Resource> resources;

}
