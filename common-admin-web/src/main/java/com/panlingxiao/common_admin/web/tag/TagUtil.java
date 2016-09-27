package com.panlingxiao.common_admin.web.tag;

import com.panlingxiao.common_admin.domain.Resource;

/**
 * Created by panlingxiao on 2016/9/27.
 */
public class TagUtil {

    private TagUtil() {

    }

    public static final String LI_URL_PATTERN = "\"<li><a %s data-title=%s href=\"%s\">%s</a></li>";
    public static final String RESOURCE_SERVICE_NAME = "resourceService";
    public static final String MENU_START_TAG = "<div class=\"menu_dropdown bk_2\">";
    public static final String MENU_END_TAG = "</div>";
    public static final String DL_START_TAG = "<dl id=\"%s\">";
    public static final String DL_END_TAG = "</dl>";
    public static final String DT_START_TAG = "<dt>";
    public static final String DT_END_TAG = "</dt>";
    public static final String MENU_ICON = " <i class=\"Hui-iconfont\">&#xe60d;</i>";
    public static final String MENU_DROPDOWN_ARROW = " <i class=\"Hui-iconfont menu_dropdown-arrow\">&#xe6d5;</i>";
    public static final String LF = "\n";
    public static final String LINK_HERF_TAG_START = " <a _href=\"%s\" data-title=\"%s\" href=\"javascript:void(0)\">";
    public static final String LINK_TAG_START = " <a  data-title=\"%s\" href=\"javascript:void(0)\">";
    public static final String LI_LINK_HERF_TAG = " <li><a _href=\"%s\" data-title=\"%s\" href=\"javascript:;\">%s</a>";
    public static final String LI_LINK_TAG = " <li><a data-title=\"%s\" href=\"javascript:;\">%s</a>";
    public static final String LINK_TAG_END = "</a>";
    public static final String LI_END_TAG = "</li>";

    /**
     * <pre>
     *    输出结果:
     *    <dt>
     *        <i class="Hui-iconfont">&#xe60d;</i>系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
     *    </dt>
     * </pre>
     */
    public static void startMenuTag(StringBuilder content, Resource resource) {
        content.append(DL_START_TAG).append(LF);
        content.append(DT_START_TAG).append(LF);
        content.append(MENU_ICON).append(LF); //显示菜单图标
        content.append(resource.getName()).append(LF);
        //显示菜单内容
        content.append(MENU_DROPDOWN_ARROW).append(LF); //显示向下箭头
        content.append(DT_END_TAG).append(LF);
    }


    /**
     * <pre>
     *   输出结果:
     *      <dl id="menu-product">
     *           <dt>
     *              <a _href="product-category.html" data-title="分类管理" href="javascript:void(0)"> <i class="Hui-iconfont">&#xe60d;</i>分类管理</a>
     *           </dt>
     *       </dl>
     * </pre>
     *
     * @param content
     * @param resource
     */
    public static void startTagWithLink(StringBuilder content, Resource resource) {
        content.append(DL_START_TAG).append(LF);
        content.append(DT_START_TAG).append(LF);
        content.append(LINK_HERF_TAG_START).append(LF);
        content.append(MENU_ICON).append(LF);
        content.append(resource.getName()).append(LF);
        content.append(LINK_TAG_END).append(LF);
        content.append(DT_END_TAG).append(LF);
    }

    /**
     * 输出<dd><ul>
     * @param content
     */
    public static void printDDAndULStartTag(StringBuilder content){
        content.append("<dd>").append(LF);
        printULStartTag(content);
    }

    public static void printDDAndULEndTag(StringBuilder content){
        printUlEndTag(content);
        content.append("</dd>").append(LF);
    }

    public static void printULStartTag(StringBuilder content){
        content.append("<ul>").append(LF);
    }

    public static void printUlEndTag(StringBuilder content){
        content.append("</ul>").append(LF);
    }


    public static void startLIAndLinkTag(StringBuilder content, Resource resource){
        content.append(String.format(LI_LINK_HERF_TAG,resource.getUrl(),resource.getName(),resource.getName())).append(LF);
    }

    public static void startLITag(StringBuilder content, Resource resource) {
        content.append(String.format(LI_LINK_TAG,resource.getName(),resource.getName())).append(LF);
    }




    public static void endLiTag(StringBuilder content){
        content.append(LI_END_TAG).append(LF);
    }


    public static void endMenuTag(StringBuilder content) {
        content.append(DL_END_TAG).append(LF);
    }


}
