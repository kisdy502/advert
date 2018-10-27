package com.sdt.advert.dao;

import com.github.pagehelper.PageInfo;
import com.sdt.advert.bean.Comment;
import org.springframework.stereotype.Component;

@Component
public interface CommentDao {
    Integer insert(Comment comment);

    PageInfo<Comment> getComments(Integer cid, int page, int limit);

    PageInfo<Comment> getCommentsWithPage(Integer cid, int page, int limit);

    Comment getCommentById(Integer coid);

    void delete(Integer coid, Integer cid);

    void update(Comment comments);
}
