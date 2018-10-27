package com.sdt.advert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminIndexController extends AbstractController {

    @GetMapping(value = {"", "/index"})
    private String index(HttpServletRequest request) {
        return "admin/index";
    }

    @GetMapping(value = "login")
    public String login() {
        return "admin/login";
    }
}
