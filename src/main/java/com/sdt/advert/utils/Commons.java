package com.sdt.advert.utils;

import com.github.pagehelper.PageInfo;
import com.sdt.advert.constant.WebConst;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangj
 * @date 2018/1/21 21:56
 */
 @Component
public class Commons {

     public static String THEME = "themes/jantent";

     private static final List EMPTY = new ArrayList(0);

    /**
     * 判断分页中是否有数据
     *
     * @param paginator
     * @return
     */
    public static boolean is_empty(PageInfo paginator) {
        return paginator == null || (paginator.getList() == null) || (paginator.getList().size() == 0);
    }

    /**
     * 网站链接
     *
     * @return
     */
    public static String site_url() {
        return site_url("/page/1");
    }

    public static String site_index() {
        return "index";
    }

    /**
     * 在管理员页面退出登录返回到登录界面
     * @return
     */
    public static String site_login() {
        return "admin/login";
    }

    /**
     * 返回网站链接下的全址
     *
     * @param sub 后面追加的地址
     * @return
     */
    public static String site_url(String sub) {
        return site_option("site_url") + sub;
    }

    /**
     *
     * 网站标题
     * @return
     */
    public static String site_title() {
        return site_option("site_title");
    }

    /**
     * 网站配置项
     *
     * @param key
     * @return
     */
    public static String site_option(String key) {
        return site_option(key, "");
    }

    /**
     * 网站配置项
     *
     * @param key
     * @param defalutValue 默认值
     * @return
     */
    public static String site_option(String key, String defalutValue) {
        if (StringUtils.isEmpty(key)) {
            return "";
        }
        String str = WebConst.initConfig.get(key);
        if (!StringUtils.isEmpty(str)) {
            return str;
        } else {
            return defalutValue;
        }
    }

    /**
     * 截取字符串
     *
     * @param str
     * @param len
     * @return
     */
    public static String substr(String str, int len) {
        if (str.length() > len) {
            return str.substring(0, len);
        }
        return str;
    }

    /**
     * 返回主题URL
     *
     * @return
     */
    public static String theme_url() {
        return site_url(Commons.THEME);
    }

    /**
     * 返回主题下的文件路径
     *
     * @param sub
     * @return
     */
    public static String theme_url(String sub) {
        return site_url(Commons.THEME + sub);
    }

    /**
     * 返回gravatar头像地址
     *
     * @param email
     * @return
     */
    public static String gravatar(String email) {
        String avatarUrl = "https://secure.gravatar.com/avatar";
        if (StringUtils.isEmpty(email)) {
            return avatarUrl;
        }
        String hash = MyUtils.MD5encode(email.trim().toLowerCase());
        return avatarUrl + "/" + hash;
    }



}
