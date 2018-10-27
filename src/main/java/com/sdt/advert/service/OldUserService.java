package com.sdt.advert.service;

import com.sdt.advert.bean.OldUser;
import com.sdt.advert.dao.OldUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OldUserService {
    @Autowired
    private OldUserDao userDao;

    public List<OldUser> queryAll() {
        return userDao.queryAll();
    }

    public int insert(OldUser city) {
        return userDao.insert(city);
    }

    public int update(OldUser city) {
        return userDao.update(city);
    }

    public OldUser queryByName(String name) {
        return userDao.queryByName(name);
    }

    public OldUser queryById(Integer id) {
        return userDao.queryById(id);
    }

    public boolean userExist(String userName) {
        return userDao.userExist(userName) > 0;
    }

    public OldUser userLogin(String userName, String passwrod) {
        return userDao.userLogin(userName, passwrod);
    }

    public int queryExpireUser(Map<String, Object> params) {
        return userDao.queryExpireUser(params);
    }
}
