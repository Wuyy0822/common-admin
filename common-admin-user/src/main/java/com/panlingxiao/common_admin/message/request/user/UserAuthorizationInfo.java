package com.panlingxiao.common_admin.message.request.user;

import com.panlingxiao.common_admin.domain.Resource;
import com.panlingxiao.common_admin.domain.Role;
import lombok.Data;

import java.util.List;

/**
 * Created by panlingxiao on 2016/9/26.
 */
@Data
public class UserAuthorizationInfo {

    private List<Resource> resources;
    private List<Role> roles;

}
