package com.mediabox.giftcardapp.dao.impl;

import com.mediabox.giftcardapp.dao.RedeemHistoryDao;
import com.mediabox.giftcardapp.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by jeffe on 7/6/2017.
 */
@Repository
public class RedeemHistoryDaoImpl implements RedeemHistoryDao {

    @Autowired
    private SessionFactory session;

    @Override
    public void add(User user) {

    }

    @Override
    public void edit(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
