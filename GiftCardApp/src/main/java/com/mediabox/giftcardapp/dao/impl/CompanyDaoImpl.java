package com.mediabox.giftcardapp.dao.impl;

import com.mediabox.giftcardapp.dao.CompanyDao;
import com.mediabox.giftcardapp.dao.UserDao;
import com.mediabox.giftcardapp.model.Company;
import com.mediabox.giftcardapp.model.GiftCard;
import com.mediabox.giftcardapp.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by jeffe on 7/6/2017.
 */
@Repository
public class CompanyDaoImpl implements CompanyDao {

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Company company) {
        this.session.getCurrentSession().save(company);
    }

    @Override
    public void edit(Company company) {

    }

    @Override
    public void delete(Company company) {

    }

    @Override
    public List<Company> findAllCompany() {
        Query query = session.getCurrentSession().createQuery("from Company");
        List list = query.list();
        return list;
    }

    @Override
    public Company getCompany(String companyID) {
        return session.getCurrentSession().get(Company.class, companyID);
    }
}
