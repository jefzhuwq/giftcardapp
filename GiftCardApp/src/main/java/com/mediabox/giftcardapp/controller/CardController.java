package com.mediabox.giftcardapp.controller;

import com.mediabox.giftcardapp.model.*;
import com.mediabox.giftcardapp.service.CompanyService;
import com.mediabox.giftcardapp.service.GiftCardService;
import com.mediabox.giftcardapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by jeffe on 7/5/2017.
 */
@Controller
@SessionAttributes("user-entity")
public class CardController {

    @Autowired
    UserService userService;

    @Autowired
    GiftCardService giftCardService;

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/newcard")
    public ModelAndView home(Principal principal) {
        String viewName = "newcard";
        ModelAndView mav = new ModelAndView(viewName);
        List<Company> companyList = this.companyService.findAllCompany();
        mav.addObject("companyList", companyList);
        return mav;
    }

    @RequestMapping(value = "/mycard")
    public ModelAndView mycard(Principal principal, HttpSession session) {
        String viewName = null;
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user-entity") != null) {
            viewName = "mycard";
            User user = (User) session.getAttribute("user-entity");
            mav.addObject("cardList", giftCardService.findGiftCardByUserID(user.getUserID()));
        } else {
            viewName = "login";
        }
        mav.setViewName(viewName);
        return mav;
    }

    @RequestMapping(value = "/cardProcess", method = RequestMethod.POST)
    public ModelAndView companyProcess(HttpServletRequest request, HttpServletResponse response, HttpSession session, GiftCard card) {
        String viewName = null;
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user-entity") != null) {
            User user = (User) session.getAttribute("user-entity");
            card.setGiftcardID(UUID.randomUUID().toString());
            card.setCardNumber(card.getCardNumber());
            card.setCardPin(card.getCardPin());
            card.setCreateTimestamp(new Date());
            card.setCompanyID(card.getCompanyID());
            card.setUpdateTimestamp(new Date());
            card.setUserID(user.getUserID());
            card.setIsEnabled(true);
            card.setExpirationDate(card.getExpirationDate());
            this.giftCardService.add(card);
            viewName = "redirect:mycard";
        } else {
            viewName = "redirect:login";
        }
        mav.setViewName(viewName);
        return mav;
    }
}
