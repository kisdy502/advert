package com.sdt.advert.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/page")
public class PageController extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(PageController.class);
}
