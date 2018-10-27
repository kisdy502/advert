package com.sdt.advert;

import com.sdt.advert.bean.User;
import com.sdt.advert.constant.WebConst;
import com.sdt.advert.utils.AdminCommons;
import com.sdt.advert.utils.Commons;
import com.sdt.advert.utils.IPUtils;
import com.sdt.advert.utils.MyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 */
@Component
public class DefaultInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(DefaultInterceptor.class);

    @Autowired
    private Commons commons;

    @Autowired
    private AdminCommons adminCommons;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        String ip = IPUtils.getIpAddr(request);
        logger.info("visit action: {}, client ip: {}", uri, ip);
        User user = MyUtils.getLoginUser(request);
        if (user == null) {
            Integer uid = MyUtils.getCooKieUid(request);
            logger.info("read cookie uid is:{}", uid);
//            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
        }
        if (uri.startsWith("/admin")
                && !uri.startsWith("/admin/login")
                && !uri.startsWith("/admin/image")
                && !uri.startsWith("/admin/js")
                && !uri.startsWith("/admin/css")
                && null == user && (1 == 2)) {          //test 不拦截任何请求了
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        request.setAttribute("commons", commons);
        request.setAttribute("adminCommons", adminCommons);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
