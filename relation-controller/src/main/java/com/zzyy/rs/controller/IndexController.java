package com.zzyy.rs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by smt6 on 2017/4/24.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/login")
    public String index() {

        return "login";
    }
}
