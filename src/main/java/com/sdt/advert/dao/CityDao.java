package com.sdt.advert.dao;

import com.sdt.advert.bean.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CityDao {

    @Select({"SELECT * FROM city"})
    List<City> queryAll();

    @Insert({"insert into city(Name,CountryCode,District,Population) values(#{name},#{countryCode},#{district},#{population})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(City city);

    @Update({"update city set Name=#{name},CountryCode=#{countryCode},District=#{district},Population=#{population} where id=#{id}"})
    int update(City city);

    @Select({"SELECT * FROM city where Name=#{name}"})
    List<City> queryByName(String name);

    @Select({"SELECT * FROM city where id=#{id}"})
    City queryById(Integer id);


}
