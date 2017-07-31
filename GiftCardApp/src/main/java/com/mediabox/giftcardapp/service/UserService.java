package com.mediabox.giftcardapp.service;

import com.mediabox.giftcardapp.model.Login;
import com.mediabox.giftcardapp.model.User;

/**
 * Created by jeffe on 7/6/2017.
 */
public interface UserService {

    void add(User user);

    User validateUser(Login login);
}
