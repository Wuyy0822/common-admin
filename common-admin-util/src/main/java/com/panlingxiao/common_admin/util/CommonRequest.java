package com.panlingxiao.common_admin.util;

import lombok.Data;

/**
 * Created by panlingxiao on 2016/8/30.
 */
@Data
public abstract class CommonRequest {
    private int startIndex;
    private int draw = 1;
    private int pageSize = 10;
}
