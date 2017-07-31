package com.mediabox.giftcardapp.controller;

import com.mediabox.giftcardapp.model.Login;
import com.mediabox.giftcardapp.model.User;
import com.mediabox.giftcardapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by jeffe on 7/5/2017.
 */
@Controller
public class HomeController {

    @Autowired
    UserService userService;

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

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, Login login) {
        ModelAndView mav = null;
        User user = userService.validateUser(login);
        if (null != user) {
            mav = new ModelAndView("welcome");
            mav.addObject("firstname", user.getFirstName());
        } else {
            mav = new ModelAndView("register");
            mav.addObject("message", "Username or Password is wrong!!");
        }
        return mav;
    }

}
