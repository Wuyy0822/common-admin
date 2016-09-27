package com.panlingxiao.common_admin.web.view;

/**
 * Created by panlingxiao on 2016/9/27.
 */
public abstract class Config {

    private static MenuDispalyStrategy crossMenuDisplayStrategy = new CrossMenuDisplayStrategy();
    private static MenuDispalyStrategy verticalMenuDisplayStrategy = new VerticalMenuDisplayStrategy();
    private static volatile MenuDispalyStrategy dispalyStrategy = verticalMenuDisplayStrategy;

    public static void changeDisplayStrategy() {
        dispalyStrategy = dispalyStrategy == verticalMenuDisplayStrategy ? crossMenuDisplayStrategy : verticalMenuDisplayStrategy;
    }

    public static MenuDispalyStrategy getDisplayStrategy() {
        return dispalyStrategy;
    }
}
