package com.sdt.advert.service;

import com.github.pagehelper.PageInfo;
import com.sdt.advert.bean.Comment;

public interface ICommentService {

    /**
     * 保存对象
     *
     * @param comment
     */
    void insertComment(Comment comment);

    /**
     * 获取文章下的评论
     *
     * @param cid
     * @param page
     * @param limit
     * @return PageInfo
     */
    PageInfo<Comment> getComments(Integer cid, int page, int limit);

    /**
     * 获取文章下的评论
     *
     * @param cid
     * @param page
     * @param limit
     * @return CommentVo
     */
    PageInfo<Comment> getCommentsWithPage(Integer cid, int page, int limit);


    /**
     * 根据主键查询评论
     *
     * @param coid
     * @return
     */
    Comment getCommentById(Integer coid);


    /**
     * 删除评论，暂时没用
     *
     * @param coid
     * @param cid
     * @throws Exception
     */
    void delete(Integer coid, Integer cid);

    /**
     * 更新评论状态
     *
     * @param comments
     */
    void update(Comment comments);
}
