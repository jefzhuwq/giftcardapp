package com.mediabox.giftcardapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by jeffe on 7/5/2017.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public ModelAndView home(Principal principal) {
//        String viewName = principal != null ? "homeSignedIn" : "homeNotSignedIn";
        String viewName = "home";
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("name", "Jeffery test");
//        DateFormat dateFormat = DateFormat.getDateTimeInstance();
//        mav.addObject("serverTime", dateFormat.format(new Date()));
        return mav;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(Principal principal) {
//        String viewName = principal != null ? "homeSignedIn" : "homeNotSignedIn";
        String viewName = "login";
        ModelAndView mav = new ModelAndView(viewName);
//        DateFormat dateFormat = DateFormat.getDateTimeInstance();
//        mav.addObject("serverTime", dateFormat.format(new Date()));
        return mav;
    }

    @RequestMapping(value = "/register")
    public ModelAndView register(Principal principal) {
//        String viewName = principal != null ? "homeSignedIn" : "homeNotSignedIn";
        String viewName = "register";
        ModelAndView mav = new ModelAndView(viewName);
//        DateFormat dateFormat = DateFormat.getDateTimeInstance();
//        mav.addObject("serverTime", dateFormat.format(new Date()));
        return mav;
    }

}
