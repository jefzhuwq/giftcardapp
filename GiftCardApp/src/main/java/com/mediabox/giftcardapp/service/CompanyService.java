package com.mediabox.giftcardapp.service;

import com.mediabox.giftcardapp.model.Company;
import com.mediabox.giftcardapp.model.User;

import java.util.List;

/**
 * Created by jeffe on 7/6/2017.
 */
public interface CompanyService {

    void add(Company company);

    List<Company> findAllCompany();
}
