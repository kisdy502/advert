package com.sdt.advert.controller;

import com.sdt.advert.ExceptionHelper;
import com.sdt.advert.RestResponse;
import com.sdt.advert.bean.Meta;
import com.sdt.advert.bean.Types;
import com.sdt.advert.exception.TipException;
import com.sdt.advert.service.IMetaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 友链管理
 */
@Controller
@RequestMapping("admin/links")
public class LinkController extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(LinkController.class);

    @Resource
    private IMetaService metaService;

    @GetMapping(value = "")
    public String index(HttpServletRequest request) {
        List<Meta> metaList = metaService.getMetaList(Types.LINK.getType(), null, 9999);
        request.setAttribute("links", metaList);
        return "admin/links";
    }

    @PostMapping(value = "save")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public RestResponse saveLink(@RequestParam String title, @RequestParam String url,
                                 @RequestParam String logo, @RequestParam Integer mid,
                                 @RequestParam(value = "sort", defaultValue = "0") int sort) {
        try {
            Meta metas = new Meta();
            metas.setName(title);
            metas.setSlug(url);
            metas.setDescription(logo);
            metas.setSort(sort);
            metas.setType(Types.LINK.getType());
            if (null != mid) {
                metas.setMid(mid);
                metaService.update(metas);
            } else {
                metaService.insert(metas);
            }
        } catch (Exception e) {
            String msg = "友链保存失败";
            return ExceptionHelper.handlerException(logger, msg, e);
        }
        return RestResponse.ok();
    }
}
