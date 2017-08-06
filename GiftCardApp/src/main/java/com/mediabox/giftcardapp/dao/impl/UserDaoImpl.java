package com.mediabox.giftcardapp.dao.impl;

import com.mediabox.giftcardapp.dao.UserDao;
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
public class UserDaoImpl implements UserDao {

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

    @Override
    public User getUserByUserNameAndPassword(String userName, String password) {
        Query query = session.getCurrentSession().createQuery("from User where userName = :username and password = :password");
        query.setParameter("username", userName);
        query.setParameter("password", password);
        List list = query.list();
        return list.size() >0 ? (User)list.get(0) : null;
    }
}
