package com.mediabox.giftcardapp.service.impl;

import com.mediabox.giftcardapp.dao.CompanyDao;
import com.mediabox.giftcardapp.dao.UserDao;
import com.mediabox.giftcardapp.model.Company;
import com.mediabox.giftcardapp.model.User;
import com.mediabox.giftcardapp.service.CompanyService;
import com.mediabox.giftcardapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jeffe on 7/6/2017.
 */
@Component
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;

    @Override
    @Transactional
    public void add(Company company) {
        this.companyDao.add(company);
    }

    @Override
    @Transactional
    public List<Company> findAllCompany() {
        return this.companyDao.findAllCompany();
    }
}
