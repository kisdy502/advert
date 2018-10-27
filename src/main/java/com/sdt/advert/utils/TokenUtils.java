package com.sdt.advert.utils;

import com.sdt.advert.bean.OldUser;
import com.sdt.advert.bean.Token;
import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;

public class TokenUtils {

    //模拟token生成
    public static String createToken(OldUser user) {
        String text = user.getUserName() + user.getPassword() + user.getLastLoginDate();
        String token = DigestUtils.md5DigestAsHex(text.getBytes());
        return Base64Utils.encodeToString(token.getBytes());
    }

    public static boolean tokenExpired(Token token) {
        return token.getExpireDate() < System.currentTimeMillis();
    }
}
