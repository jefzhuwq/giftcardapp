package com.mediabox.giftcardapp.controller;

import com.mediabox.giftcardapp.exceptions.NoPermissionException;
import com.mediabox.giftcardapp.model.*;
import com.mediabox.giftcardapp.service.CompanyService;
import com.mediabox.giftcardapp.service.GiftCardService;
import com.mediabox.giftcardapp.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.*;

/**
 * Created by jeffe on 7/5/2017.
 */
@Controller
@Log4j
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
            viewName = "redirect:login";
        }
        mav.setViewName(viewName);
        return mav;
    }

    @RequestMapping(value = "/editcard/{id}")
    public ModelAndView editcard(Principal principal, HttpSession session, @PathVariable("id") String id) {
        String viewName = null;
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user-entity") != null) {
            User user = (User) session.getAttribute("user-entity");
            GiftCard card = giftCardService.getGiftCard(id);
            if (user.getUserID().equals(card.getUserID())) {
                viewName = "editcard";
                mav.addObject("card", card);
                List<Company> companyList = this.companyService.findAllCompany();
                mav.addObject("companyList", companyList);
            } else {
                throw new NoPermissionException();
            }
        } else {
            viewName = "redirect:/login";
        }
        mav.setViewName(viewName);
        return mav;
    }

    @RequestMapping(value = "/sellcard/{id}")
    public ModelAndView sellcard(Principal principal, HttpSession session, @PathVariable("id") String id) {
        String viewName = null;
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user-entity") != null) {
            User user = (User) session.getAttribute("user-entity");
            GiftCard card = giftCardService.getGiftCard(id);
            if (user.getUserID().equals(card.getUserID())) {
                viewName = "sellcard";
                mav.addObject("card", card);
            } else {
                throw new NoPermissionException();
            }
        } else {
            viewName = "redirect:/login";
        }
        mav.setViewName(viewName);
        return mav;
    }

    @RequestMapping(value = "/deletecard/{id}")
    public ModelAndView deletecard(Principal principal, HttpSession session, @PathVariable("id") String id) {
        String viewName = null;
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user-entity") != null) {
            User user = (User) session.getAttribute("user-entity");
            GiftCard card = giftCardService.getGiftCard(id);
            if (user.getUserID().equals(card.getUserID())) {
                giftCardService.delete(id);
                viewName = "redirect:/mycard";
            } else {
                throw new NoPermissionException();
            }
        } else {
            viewName = "redirect:/login";
        }
        mav.setViewName(viewName);
        return mav;
    }

    @RequestMapping(value = "/requestcard")
    public ModelAndView requestcard(Principal principal, HttpSession session) {
        String viewName = null;
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user-entity") != null) {
            User user = (User) session.getAttribute("user-entity");
            viewName = "requestcard";
//            Set<Company> companySet = giftCardService.getAllCompanyOnUserGiftCard(user.getUserID());
            List<GiftCard> mergedCardList = this.getMergedGiftCardList(user.getUserID());
            mav.addObject("mergedCardList", mergedCardList);
        } else {
            viewName = "redirect:/login";
        }
        mav.setViewName(viewName);
        return mav;
    }

    @RequestMapping(value = "/cardProcess", method = RequestMethod.POST)
    public ModelAndView cardProcess(HttpServletRequest request, HttpServletResponse response, HttpSession session, GiftCard card) {
        String viewName = null;
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user-entity") != null) {
            User user = (User) session.getAttribute("user-entity");
            card.setCardNumber(card.getCardNumber());
            card.setCardPin(card.getCardPin());
            card.setCompanyID(card.getCompanyID());
            card.setUpdateTimestamp(new Date());
            card.setIsEnabled(true);
            card.setExpirationDate(card.getExpirationDate());
            card.setUserID(user.getUserID());
            if (card.getGiftcardID() == null) {
                card.setGiftcardID(UUID.randomUUID().toString());
                card.setCreateTimestamp(new Date());
            } else {
                card.setCreateTimestamp(card.getCreateTimestamp());
            }
            this.giftCardService.add(card);

            viewName = "redirect:mycard";
        } else {
            viewName = "redirect:/login";
        }
        mav.setViewName(viewName);
        return mav;
    }

    @RequestMapping(value = "/sellCardProcess", method = RequestMethod.POST)
    public ModelAndView sellCardProcess(HttpServletRequest request, HttpServletResponse response, HttpSession session, GiftCard card) {
        String viewName = null;
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user-entity") != null) {
            User user = (User) session.getAttribute("user-entity");
            card.setCardNumber(card.getCardNumber());
            card.setCardPin(card.getCardPin());
            card.setCompanyID(card.getCompanyID());
            card.setUpdateTimestamp(new Date());
            card.setIsEnabled(true);
            card.setExpirationDate(card.getExpirationDate());
            card.setUserID(user.getUserID());
            card.setIsForSale(card.getIsForSale());
            card.setSalesPrice(card.getSalesPrice());
            if (card.getGiftcardID() == null) {
                card.setGiftcardID(UUID.randomUUID().toString());
                card.setCreateTimestamp(new Date());
            } else {
                card.setCreateTimestamp(card.getCreateTimestamp());
            }
            this.giftCardService.add(card);

            viewName = "redirect:mycard";
        } else {
            viewName = "redirect:/login";
        }
        mav.setViewName(viewName);
        return mav;
    }

    private List<GiftCard> getMergedGiftCardList(String userID) {
        List<GiftCard> cardList = this.giftCardService.findGiftCardByUserID(userID);
        return this.mergeGiftCard(cardList);
    }

    private List<GiftCard> mergeGiftCard(List<GiftCard> cardList) {
        List<GiftCard> result = new ArrayList<>();
        for (GiftCard card : cardList) {
            if (card.getCompanyID() != null) {
                boolean isFound = false;
                for (GiftCard finalCard : result) {
                    if (finalCard.getCompanyID().equals(card.getCompanyID())) {
                        finalCard.setRemainingCredit(finalCard.getRemainingCredit() + card.getRemainingCredit());
                        isFound = true;
                    }
                }
                if (!isFound) {
                    result.add(card);
                }
            }
        }
        return result;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(Exception e) {
        log.warn("Returning HTTP 400 Bad Request", e);
    }
}
