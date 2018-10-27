package com.sdt.advert.dao;

import com.sdt.advert.bean.Content;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ContentDao {

    int deleteById(@Param("cid") Integer cid);

    int insert(Content content);

    int update(Content content);

    List<Content> findByTag(String tag);

    Content getConent(Integer cid);

    Content getConentBySlug(@Param("slug") String slug);
}
