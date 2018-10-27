package com.sdt.advert.controller;

import com.sdt.advert.bean.Meta;
import com.sdt.advert.bean.Types;
import com.sdt.advert.service.IMetaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 分类标签管理
 */
@Controller
@RequestMapping("admin/category")
public class CategoryController extends AbstractController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Resource
    private IMetaService metaService;

    @GetMapping(value = "")
    public String index(HttpServletRequest request) {
        List<Meta> categoryList = metaService.getMetaList(Types.CATEGORY.getType(), null, 9999);
        List<Meta> tagList = metaService.getMetaList(Types.TAG.getType(), null, 9999);
        logger.info("categoryList:" + (categoryList != null));
        logger.info("tagList:" + (tagList != null));
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("tagList", tagList);
        return "admin/category";
    }
}
