package com.mediabox.giftcardapp.dao;

import com.mediabox.giftcardapp.model.Company;
import com.mediabox.giftcardapp.model.User;

import java.util.List;

/**
 * Created by jeffe on 7/6/2017.
 */
public interface CompanyDao {

    void add(Company company);

    void edit(Company company);

    void delete(Company company);

    List<Company> findAllCompany();

    Company getCompany(String companyID);
}
