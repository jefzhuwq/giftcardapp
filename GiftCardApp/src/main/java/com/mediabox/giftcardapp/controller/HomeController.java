package com.mediabox.giftcardapp.controller;

import com.mediabox.giftcardapp.model.Login;
import com.mediabox.giftcardapp.model.Register;
import com.mediabox.giftcardapp.model.User;
import com.mediabox.giftcardapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by jeffe on 7/5/2017.
 */
@SessionAttributes("user-entity")
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
        String viewName = "login";
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("login", new Login());
        return mav;
    }

    @RequestMapping(value = "/register")
    public ModelAndView register(Principal principal) {
//        String viewName = principal != null ? "homeSignedIn" : "homeNotSignedIn";
        String viewName = "register";
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("login", new Login());
        return mav;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, HttpSession session, Login login) {
        ModelAndView mav = null;
        User user = userService.validateUser(login);
        if (null != user) {
            mav = new ModelAndView("welcome");
            mav.addObject("firstname", user.getFirstName());
            session.setAttribute("user-entity", user);
        } else {
            mav = new ModelAndView("register");
            session.removeAttribute("user-entity");
            mav.addObject("message", "Username or Password is wrong!!");
        }
        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, Register register) {
        ModelAndView mav = null;
        User user = new User();
        user.setUserID(UUID.randomUUID().toString());
        user.setUserName(register.getUsername());
        user.setPassword(register.getPassword());
        user.setEmail(register.getEmail());
        user.setCreateTimestamp(new Date());
        user.setUpdateTimestamp(new Date());
        user.setIsEnabled(true);
        this.userService.add(user);
        return mav;
    }

    @RequestMapping(value = "/welcome")
    public ModelAndView welcome(Principal principal) {
        String viewName = "welcome";
        ModelAndView mav = new ModelAndView(viewName);
        return mav;
    }

}
