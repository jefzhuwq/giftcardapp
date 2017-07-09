package com.mediabox.giftcardapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jeffe on 7/5/2017.
 */
@Controller
public class CompanyController {
    @RequestMapping(value = "/")
    public String home() {
        return "header";
    }

}
