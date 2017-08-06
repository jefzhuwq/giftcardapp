package com.mediabox.giftcardapp.service.impl;

import com.mediabox.giftcardapp.dao.GiftCardDao;
import com.mediabox.giftcardapp.model.GiftCard;
import com.mediabox.giftcardapp.model.User;
import com.mediabox.giftcardapp.service.GiftCardService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jeffe on 7/6/2017.
 */
@Component
public class GiftCardServiceImpl implements GiftCardService {

    @Autowired
    private GiftCardDao giftCardDao;


    @Override
    @Transactional
    public void add(GiftCard card) {
        this.giftCardDao.add(card);
    }

    @Override
    @Transactional
    public List<GiftCard> findGiftCardByUserID(String userID) {
        return giftCardDao.findGiftCardByUserId(userID);
    }
}
