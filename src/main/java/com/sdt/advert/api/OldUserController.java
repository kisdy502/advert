package com.sdt.advert.api;

import com.sdt.advert.bean.OldUser;
import com.sdt.advert.bean.Token;
import com.sdt.advert.service.TokenService;
import com.sdt.advert.service.OldUserService;
import com.sdt.advert.utils.IPUtils;
import com.sdt.advert.utils.TokenUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class OldUserController {
    private static Logger logger = LoggerFactory.getLogger(OldUserController.class);

    @Autowired
    private OldUserService userService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping("/queryAll")
    public List<OldUser> queryAll() {
        return userService.queryAll();
    }

    @RequestMapping("/register")
    public int register(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        @RequestParam("loginDevice") String loginDevice) {
        OldUser user = new OldUser();
        user.setUserName(userName);
        user.setPassword(password);
        user.setLoginDevice(loginDevice);
        user.setRegistdate(System.currentTimeMillis());
        user.setLastLoginDate(-1);
        boolean exist = userService.userExist(userName);
        logger.info("userExist:" + exist);
        if (exist) {
            return -2;
        } else {
            return userService.insert(user);
        }
    }

    @RequestMapping("/queryExpireUser")
    public int queryExpireUser(HttpServletRequest request,@RequestParam Map<String, Object> params) {
        IPUtils.printfHeader(request);
        return userService.queryExpireUser(params);
    }

    @RequestMapping("/login")
    public OldUser login(@RequestParam("userName") String userName,
                         @RequestParam("password") String password) {

        logger.info("userName:" + userName);
        logger.info("password:" + password);
        OldUser user = userService.userLogin(userName, password);
        if (user != null) {
            user.setLastLoginDate(System.currentTimeMillis());
            Token tk = tokenService.queryByUid(user.getId());
            if (tk == null || TokenUtils.tokenExpired(tk)) {
                String strToken = TokenUtils.createToken(user);
                tk = new Token();
                tk.setUid(user.getId());
                tk.setToken(strToken);
                tk.setExpireDate(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 30); //token过去三十天
                tokenService.insert(tk);
                user.setToken(strToken);

            } else {
                user.setToken(tk.getToken());
            }
            return user;
        } else {
            return new OldUser();
        }
    }

    @RequestMapping("/update")
    public int update(OldUser user) {
        return userService.update(user);
    }

    @RequestMapping("/queryByName")
    public OldUser queryByName(String name) {
        return userService.queryByName(name);
    }

    @RequestMapping("/queryById")
    public OldUser queryById(Integer id) {
        return userService.queryById(id);
    }

    @RequestMapping("/deviceLogin")
    public Object deviceLogin(@Param("token") String token) {
        return null;
    }
}
