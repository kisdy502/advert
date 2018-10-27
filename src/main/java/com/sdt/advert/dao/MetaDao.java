package com.sdt.advert.dao;

import com.sdt.advert.bean.Meta;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface MetaDao {
    List<Meta> getMetaList(@Param("type") String type,@Param("mid") String mid,@Param("order") String order,@Param("limit") int limit);

    Meta insertByParam(Map<String, Object> params);

    Meta insert(Meta meta);

    Integer delete(Integer id);

    Meta update(Meta meta);
}