package com.panlingxiao.common_admin.message.request.user;

import com.panlingxiao.common_admin.util.CommonRequest;
import lombok.Data;

import java.util.Date;

/**
 * Created by panlingxiao on 2016/8/30.
 */
@Data
public class UserRequest extends CommonRequest {

    private String param;

    private Date startTime;

    private Date endTime;

}
