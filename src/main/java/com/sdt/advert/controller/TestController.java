package com.sdt.advert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class TestController extends AbstractController{

    @GetMapping(value = "/test")
    private String indexTest(HttpServletRequest request) {
        return this.render("test");
    }

    @GetMapping(value = "/test2")
    private String indexTest2(HttpServletRequest request) {
        return this.render("test2");
    }

    @GetMapping(value = "/test3")
    private String indexTest3(HttpServletRequest request) {
        return this.render("test3");
    }

    @GetMapping(value = "/test4")
    private String indexTest4(HttpServletRequest request) {
        return this.render("test4");
    }

    @GetMapping(value = "/test5")
    private String indexTest5(HttpServletRequest request) {
        return this.render("test5");
    }


    @GetMapping(value = "/test6")
    private String indexTest6(HttpServletRequest request) {
        return this.render("test6");
    }

    @GetMapping(value = "/test7")
    private String indexTest7(HttpServletRequest request) {
        return this.render("test7");
    }

    @GetMapping(value = "/test8")
    private String indexTest8(HttpServletRequest request) {
        return this.render("test8");
    }


    @GetMapping(value = "/test9")
    private String test9(HttpServletRequest request) {
        return this.render("test9");
    }

    @GetMapping(value = "/test10")
    private String test10(HttpServletRequest request) {
        return this.render("test10");
    }


    @GetMapping(value = "/test11")
    private String test11(HttpServletRequest request) {
        return this.render("test11");
    }

    @GetMapping(value = "/test12")
    private String test12(HttpServletRequest request) {
        return this.render("test12");
    }

    @GetMapping(value = "/test13")
    private String test13(HttpServletRequest request) {
        return this.render("test13");
    }

    @GetMapping(value = "/test15")
    private String test15(HttpServletRequest request) {
        return this.render("test15");
    }

    @GetMapping(value = "/test16")
    private String test16(HttpServletRequest request) {
        return this.render("test16");
    }

    @GetMapping(value = "/test17")
    private String test17(HttpServletRequest request) {
        return this.render("test17");
    }

    @GetMapping(value = "/test18")
    private String test18(HttpServletRequest request) {
        return this.render("test18");
    }

    @GetMapping(value = "/test19")
    private String test19(HttpServletRequest request) {
        return this.render("test19");
    }

    @GetMapping(value = "/test20")
    private String test20(HttpServletRequest request) {
        return this.render("test20");
    }

    @GetMapping(value = "/test21")
    private String test21(HttpServletRequest request) {
        return this.render("test21");
    }

    @GetMapping(value = "/test22")
    private String test22(HttpServletRequest request) {
        return this.render("test22");
    }
    @GetMapping(value = "/test23")
    private String test23(HttpServletRequest request) {
        return this.render("test23");
    }

}
