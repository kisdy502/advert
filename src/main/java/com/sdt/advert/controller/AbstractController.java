package com.sdt.advert.controller;

import com.sdt.advert.bean.User;
import com.sdt.advert.utils.MyUtils;

import javax.servlet.http.HttpServletRequest;

public class AbstractController {
    public static String THEME = "front";

//    protected MapCache cache = MapCache.single();

    /**
     * 主页的页面主题
     *
     * @param viewName
     * @return
     */
    public String render(String viewName) {
        return THEME + "/" + viewName;
    }

    public AbstractController title(HttpServletRequest request, String title) {
        request.setAttribute("title", title);
        return this;
    }

    public AbstractController keywords(HttpServletRequest request, String keywords) {
        request.setAttribute("keywords", keywords);
        return this;
    }

    public User user(HttpServletRequest request) {
//        return MyUtils.getLoginUser(request);
        return null;
    }

    public Integer getUid(HttpServletRequest request) {
        return this.user(request).getUid();
    }

    public String render_404() {
        return "comm/error_404";
    }
}
