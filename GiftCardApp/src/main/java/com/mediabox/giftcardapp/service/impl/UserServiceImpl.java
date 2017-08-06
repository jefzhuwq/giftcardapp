package com.mediabox.giftcardapp.service.impl;

import com.mediabox.giftcardapp.dao.UserDao;
import com.mediabox.giftcardapp.model.Login;
import com.mediabox.giftcardapp.model.User;
import com.mediabox.giftcardapp.service.UserService;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jeffe on 7/6/2017.
 */
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private SessionFactory session;

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void add(User user) {
        this.session.getCurrentSession().save(user);
    }

    @Override
    @Transactional
    public User validateUser(Login login) {
        return userDao.getUserByUserNameAndPassword(login.getUsername(), login.getPassword());
    }
}
