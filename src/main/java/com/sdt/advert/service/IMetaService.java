package com.sdt.advert.service;

import com.sdt.advert.bean.Meta;

import java.util.List;
import java.util.Map;

public interface IMetaService {
    /**
     * 根据类型和名字查询项
     * @return
     */
    List<Meta> getMetaList(String type, String orderby, int limit);

    Meta insert(Map<String, Object> params);

    Meta insert(Meta meta);

    Meta update(Meta meta);

    Integer delete(Integer id);

}
