package com.sdt.advert.service;

import com.sdt.advert.bean.Content;

import java.util.List;

public interface IContentService {

    Content getConent(String cid);

    int deleteById(Integer cid);

    int publish(Content content);

    int updateByPrimaryKey(Content content);

    List<Content> findByTag(String tag);
}
