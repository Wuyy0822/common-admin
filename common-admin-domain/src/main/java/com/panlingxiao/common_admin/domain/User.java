package com.panlingxiao.common_admin.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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



}
