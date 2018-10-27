package com.sdt.advert.service;

import com.sdt.advert.bean.Token;
import com.sdt.advert.dao.TokenDao;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    private TokenDao tokenDao;

    public  int insert(Token token) {
        return tokenDao.insert(token);
    }

    public  int update(Token token) {
        return tokenDao.update(token);
    }

    public  Token queryByUid(@Param("uid") Integer uid) {
        return tokenDao.queryByUid(uid);
    }

}
