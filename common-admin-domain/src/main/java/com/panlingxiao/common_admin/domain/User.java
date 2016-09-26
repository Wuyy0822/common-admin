package com.panlingxiao.common_admin.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

/**
 * Created by panlingxiao on 2016/8/29.
 */
@Setter
@Getter
@ToString
public class User {

    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nickname;


    /**
     * 用户状态
     */
    private boolean status;

    /**
     *  加密密码的盐值
     */
    private String salt;

    /**
     * 用户是否锁定
     */
    private boolean locked;

    /**
     * 用户具备的角色列表
     */
    private List<Integer> roleIds;

    private Set<Role> roles;

    private Set<Resource> resources;


    public String getRoleIdsString(){
        if(roleIds == null || roleIds.isEmpty()){
            return null;
        }
        StringBuilder builder = new StringBuilder();

        final int size = roleIds.size();
        for(int i = 0;i < size;i++){
            builder.append(roleIds.get(i));
            if(i != size - 1){
                builder.append(",");
            }
        }
        return builder.toString();
    }



}
