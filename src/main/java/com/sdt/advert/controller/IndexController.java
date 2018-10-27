package com.sdt.advert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

    // 映射"/"请求
    @RequestMapping({"/","index"})
    public String index(Model model) {
        System.out.println("IndexController index方法被调用......");
        // 根据Thymeleaf默认模板，将返回resources/templates/index.html
        return "index";
    }


}
