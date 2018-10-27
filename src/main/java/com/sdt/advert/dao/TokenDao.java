package com.sdt.advert.dao;

import com.sdt.advert.bean.Token;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TokenDao {

    @Insert({"insert into token(uid,token,expireDate) values(#{uid},#{token},#{expireDate})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Token token);

    @Update({"update token set uid=#{uid},token=#{token},expireDate=#{expireDate} where id=#{id}"})
    int update(Token token);


    @Select({"SELECT * FROM token where uid=#{uid}"})
    Token queryByUid(@Param("uid") Integer uid);

}
