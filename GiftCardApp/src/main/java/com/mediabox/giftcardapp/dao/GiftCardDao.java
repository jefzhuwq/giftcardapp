package com.mediabox.giftcardapp.dao;

import com.mediabox.giftcardapp.model.User;

/**
 * Created by jeffe on 7/6/2017.
 */
public interface GiftCardDao {

    public void add(User user);

    public void edit(User user);

    public void delete(User user);
}
