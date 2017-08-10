package com.mediabox.giftcardapp.dao.impl;

import com.mediabox.giftcardapp.dao.GiftCardDao;
import com.mediabox.giftcardapp.dao.UserDao;
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
public class GiftCardDaoImpl implements GiftCardDao {

    @Autowired
    private SessionFactory session;

    @Override
    public void add(GiftCard card) {
        this.session.getCurrentSession().save(card);
    }

    @Override
    public void edit(GiftCard card) {

    }

    @Override
    public void delete(String cardID) {
        GiftCard card = this.getGiftCard(cardID);
        this.session.getCurrentSession().delete(card);
    }

    @Override
    public List<GiftCard> findGiftCardByUserId(String userID) {
        Query query = session.getCurrentSession().createQuery("from GiftCard where userID = :userid");
        query.setParameter("userid", userID);
        List list = query.list();
        return list;
    }

    @Override
    public GiftCard getGiftCard(String cardID) {
        return session.getCurrentSession().get(GiftCard.class, cardID);
    }


}
