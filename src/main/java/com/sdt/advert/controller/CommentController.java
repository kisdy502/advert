package com.sdt.advert.controller;

import com.github.pagehelper.PageInfo;
import com.sdt.advert.service.ICommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 评论模块
 */
@Controller
@RequestMapping("admin/comments")
public class CommentController extends AbstractController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Resource
    private ICommentService commentServcie;

    @GetMapping(value = "")
    public String index(@RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "limit", defaultValue = "15") int limit, HttpServletRequest request) {
        return "admin/comment_list";
    }
}
