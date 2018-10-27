package com.sdt.advert.dao;

import com.sdt.advert.bean.User;
import com.sdt.advert.bean.UserVoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tangj
 * @date 2018/1/21 14:59
 */
@Component
public interface UserDao {
    long countByExample(UserVoExample example);

    int deleteByExample(UserVoExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserVoExample example);

    User selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserVoExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserVoExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
