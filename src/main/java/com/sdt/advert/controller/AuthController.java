package com.sdt.advert.controller;

import com.sdt.advert.RestResponse;
import com.sdt.advert.bean.User;
import com.sdt.advert.constant.WebConst;
import com.sdt.advert.service.IUserService;
import com.sdt.advert.utils.MyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin")
public class AuthController {
    private static Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Resource
    private IUserService userService;

    @PostMapping(value = "login")
    @ResponseBody
    public RestResponse doLogin(@RequestParam String username,
                                @RequestParam String password,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        logger.info("userName:{},password:{}", username, password);

        try {
            User user = userService.login(username, password);
            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
            MyUtils.setCookie(response, user.getUid());
            return RestResponse.ok();
        } catch (Exception e) {
            logger.error("error:{}", e.getMessage());
            return RestResponse.fail(e.getMessage());
        }


    }
}
