package com.mediabox.giftcardapp.dao;

import com.mediabox.giftcardapp.model.User;

/**
 * Created by jeffe on 7/6/2017.
 */
public interface UserDao {

    void add(User user);

    void edit(User user);

    void delete(User user);

    User getUserByUserNameAndPassword(String userName, String password);
}
