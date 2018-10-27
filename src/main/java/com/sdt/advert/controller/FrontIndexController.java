package com.sdt.advert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class FrontIndexController extends AbstractController {
    @GetMapping(value = "/")
    private String index(HttpServletRequest request) {
        return this.render("index");
    }





}
