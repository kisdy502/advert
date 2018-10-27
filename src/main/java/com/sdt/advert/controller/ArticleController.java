package com.sdt.advert.controller;

import com.sdt.advert.bean.Content;
import com.sdt.advert.bean.Meta;
import com.sdt.advert.bean.Types;
import com.sdt.advert.exception.TipException;
import com.sdt.advert.service.IContentService;
import com.sdt.advert.service.IMetaService;
import com.sdt.advert.utils.Commons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 文章管理
 */
@Controller
@RequestMapping("/admin/article")
@Transactional(rollbackFor = TipException.class)
public class ArticleController extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Resource
    private IContentService contentService;

    @Resource
    private IMetaService metaService;

    /**
     * 文章发表页面
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/publish")
    public String newArticle(HttpServletRequest request) {
        List<Meta> categories = metaService.getMetaList(Types.CATEGORY.getType(), null, 9999);
        request.setAttribute("categories", categories);
        request.setAttribute(Types.ATTACH_URL.getType(), Commons.site_option(Types.ATTACH_URL.getType()));
        return "admin/article_edit";
    }

    /**
     * 文章编辑页面
     *
     * @param cid     id或者自定义的访问地址
     * @param request
     * @return
     */
    @GetMapping(value = "/{cid}")
    public String editArticle(@PathVariable String cid, HttpServletRequest request) {
        Content contents = contentService.getConent(cid);
        request.setAttribute("contents", contents);
        List<Meta> categories = metaService.getMetaList(Types.CATEGORY.getType(), null, 9999);
        request.setAttribute("categories", categories);
        request.setAttribute(Types.ATTACH_URL.getType(), Commons.site_option(Types.ATTACH_URL.getType()));
        request.setAttribute("active", "article");
        return "admin/article_edit";
    }

}
