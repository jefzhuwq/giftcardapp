package com.mediabox.giftcardapp.service.impl;

import com.mediabox.giftcardapp.model.Login;
import com.mediabox.giftcardapp.model.User;
import com.mediabox.giftcardapp.service.UserService;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by jeffe on 7/6/2017.
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private SessionFactory session;

    @Override
    public void add(User user) {

    }

    @Override
    public User validateUser(Login login) {
        Query query = session.getCurrentSession().createQuery("from User where userName = :username and password = :password");
        query.setParameter("username", login.getUsername());
        query.setParameter("password", login.getPassword());
        List list = query.list();
        return list.size() >0 ? (User)list.get(0) : null;
    }
}
