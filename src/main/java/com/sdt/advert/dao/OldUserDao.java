package com.sdt.advert.dao;

import com.sdt.advert.bean.OldUser;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface OldUserDao {

    @Select({"SELECT * FROM OldUser"})
    List<OldUser> queryAll();

    @Insert({"insert into user(userName,password,registdate,lastLoginDate) values(#{userName},#{password},#{registdate},#{lastLoginDate})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(OldUser city);

    @Update({"update user set userName=#{userName},password=#{password},registdate=#{registdate},lastLoginDate=#{lastLoginDate} where id=#{id}"})
    int update(OldUser city);

    @Select({"SELECT * FROM user where userName=#{userName} limit 0"})
    OldUser queryByName(@Param("userName") String userName);

    @Select({"SELECT * FROM user where id=#{id}"})
    OldUser queryById(@Param("id") Integer id);

    @Select({"SELECT count(*) FROM user where userName=#{userName}"})
    int userExist(@Param("userName") String userName);

    @Select({"SELECT * FROM user where userName=#{userName} and password=#{password}"})
    OldUser userLogin(@Param("userName") String userName, @Param("password") String password);

    @Select({"SELECT count(*) FROM user where userName=#{userName} and password=#{password} and lastLoginDate =#{lastLoginDate}"})
    int queryExpireUser(Map<String, Object> params);
}
