package com.sdt.advert.service.impl;

import com.github.pagehelper.PageInfo;
import com.sdt.advert.bean.Comment;
import com.sdt.advert.dao.CommentDao;
import com.sdt.advert.service.ICommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements ICommentService {
    CommentDao commentDao;

    @Override
    public void insertComment(Comment comment) {
        commentDao.insert(comment);
    }

    @Override
    public PageInfo<Comment> getComments(Integer cid, int page, int limit) {
        return commentDao.getComments(cid,page,limit);
    }

    @Override
    public PageInfo<Comment> getCommentsWithPage(Integer cid, int page, int limit) {
        return commentDao.getCommentsWithPage(cid, page, limit);
    }

    @Override
    public Comment getCommentById(Integer coid) {
        return commentDao.getCommentById(coid);
    }

    @Override
    public void delete(Integer coid, Integer cid) {
        commentDao.delete(coid, cid);
    }

    @Override
    public void update(Comment comments) {
        commentDao.update(comments);
    }
}
