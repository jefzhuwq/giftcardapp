package com.mediabox.giftcardapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jeffe on 7/5/2017.
 */
@Controller
public class GiftCardController {
    @RequestMapping(value = "/gitcard")
    public String home() {
        return "home";
    }

}
