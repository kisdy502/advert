package com.sdt.advert.service.impl;

import com.sdt.advert.bean.Meta;
import com.sdt.advert.dao.MetaDao;
import com.sdt.advert.service.IMetaService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author tangj
 * @date 2018/1/24 21:59
 */
@Service
public class MetaServiceImpl implements IMetaService {

    @Resource
    private MetaDao metaDao;

    @Override
    public List<Meta> getMetaList(String type, String orderby, int limit) {
        return metaDao.getMetaList(type, "mid", "desc", limit);
    }

    @Override
    public Meta insert(Map<String, Object> params) {
        return metaDao.insertByParam(params);
    }

    @Override
    public Meta insert(Meta meta) {
        return metaDao.insert(meta);
    }

    @Override
    public Meta update(Meta meta) {
        return metaDao.update(meta);
    }

    @Override
    public Integer delete(Integer id) {
        return metaDao.delete(id);
    }
}
