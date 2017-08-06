package com.mediabox.giftcardapp.controller;

import com.mediabox.giftcardapp.model.Company;
import com.mediabox.giftcardapp.model.Register;
import com.mediabox.giftcardapp.model.User;
import com.mediabox.giftcardapp.service.CompanyService;
import com.mediabox.giftcardapp.service.GiftCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by jeffe on 7/5/2017.
 */
@Controller
public class CompanyController {
    @Autowired
    CompanyService companyService;


    @RequestMapping(value = "/newcompany")
    public ModelAndView newcompany() {
        String viewName = "newcompany";
        ModelAndView mav = new ModelAndView(viewName);
        return mav;
    }

    @RequestMapping(value = "/companyProcess", method = RequestMethod.POST)
    public ModelAndView companyProcess(HttpServletRequest request, HttpServletResponse response, Company company) {
        company.setCompanyID(UUID.randomUUID().toString());
        company.setCompanyName(company.getCompanyName());
        company.setCreateTimestamp(new Date());
        company.setUpdateTimestamp(new Date());
        company.setIsPublic(true);
        this.companyService.add(company);
        ModelAndView mav = new ModelAndView("redirect:companylist");
        return mav;
    }

    @RequestMapping(value = "/companylist")
    public ModelAndView companylist() {
        String viewName = "companylist";
        ModelAndView mav = new ModelAndView(viewName);
        List<Company> companyList = companyService.findAllCompany();
        mav.addObject("companyList", companyList);
        return mav;
    }


}
