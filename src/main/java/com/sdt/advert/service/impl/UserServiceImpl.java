package com.sdt.advert.service.impl;

import com.sdt.advert.bean.User;
import com.sdt.advert.bean.UserVoExample;
import com.sdt.advert.dao.UserDao;
import com.sdt.advert.exception.TipException;
import com.sdt.advert.service.IUserService;
import com.sdt.advert.utils.MyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import javax.annotation.Resource;
import java.util.List;

/**
 * @author tangj
 * @date 2018/1/21 14:31
 */
@Service
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;

    @Override
    public Integer insertUser(User user) {
        Integer uid = null;
        if (!StringUtils.isEmpty(user.getUsername()) && !StringUtils.isEmpty(user.getEmail())) {
            //用户密码摘要
            String encodePwd = MyUtils.MD5encode(user.getUsername() + user.getPassword());
            user.setPassword(encodePwd);
            userDao.insertSelective(user);
        }
        return user.getUid();
    }

    @Override
    public User queryUserById(Integer uid) {
        User userVo = null;
        if (uid != null) {
            userVo = userDao.selectByPrimaryKey(uid);
        }
        return userVo;
    }

    @Override
    public User login(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new TipException("用户名和密码为空");
        }
        UserVoExample example = new UserVoExample();
        UserVoExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        long count = userDao.countByExample(example);
        if (count < 1) {
            throw new TipException("不存在该用户");
        }
        String pwd = MyUtils.MD5encode(username + password);
        logger.info("password:" + pwd);
        criteria.andPasswordEqualTo(pwd);
        List<User> userVoList = userDao.selectByExample(example);
        if (userVoList.size() != 1) {
            logger.info("用户名或者密码错误:");
            throw new TipException("用户名或者密码错误");
        }
        return userVoList.get(0);
    }

    @Override
    public void updateByUid(User user) {
        if (null == user || null == user.getUid()) {
            throw new TipException("userVo is null");
        }
        int i = userDao.updateByPrimaryKeySelective(user);
        if (i != 1) {
            throw new TipException("update user by uid and retrun is not one");
        }
    }
}
