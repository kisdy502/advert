package com.sdt.advert.service.impl;

import com.sdt.advert.bean.Content;
import com.sdt.advert.dao.ContentDao;
import com.sdt.advert.service.IContentService;
import com.sdt.advert.utils.Tools;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContentServiceImpl implements IContentService {

    @Resource
    ContentDao icontentDao;

    @Override
    public Content getConent(String cid) {
        if (!StringUtils.isEmpty(cid) && Tools.isNumber(cid)) {
            Content content = icontentDao.getConent(Integer.parseInt(cid));
            content.setHits(content.getHits() + 1);
            icontentDao.update(content);
            return content;
        } else {
            Content content = icontentDao.getConentBySlug(cid);
            content.setHits(content.getHits() + 1);
            icontentDao.update(content);
            return content;
        }
    }

    @Override
    public int deleteById(Integer cid) {
        return icontentDao.deleteById(cid);
    }

    @Override
    public int publish(Content content) {
        return icontentDao.insert(content);
    }

    @Override
    public int updateByPrimaryKey(Content content) {
        return icontentDao.update(content);
    }

    @Override
    public List<Content> findByTag(String tag) {
        return icontentDao.findByTag(tag);
    }
}
