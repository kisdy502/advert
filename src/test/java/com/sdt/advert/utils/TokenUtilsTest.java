package com.sdt.advert.utils;

import com.sdt.advert.bean.OldUser;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenUtilsTest {
    private static Logger logger = LoggerFactory.getLogger(TokenUtilsTest.class);

    @Test
    public void createToken() {
        OldUser user = new OldUser();
        user.setUserName("test168");
        user.setPassword("test123");
        user.setLastLoginDate(1540201649927L);
        String token = TokenUtils.createToken(user);
        logger.info("token:" + token);
    }
}