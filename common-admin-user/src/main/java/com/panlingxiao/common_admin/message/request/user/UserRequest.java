package com.panlingxiao.common_admin.message.request.user;

import lombok.Data;

/**
 * Created by panlingxiao on 2016/8/30.
 */
@Data
public class UserRequest {

    private int startIndex;
    private int draw = 1;
    private int pageSize = 10;


}
