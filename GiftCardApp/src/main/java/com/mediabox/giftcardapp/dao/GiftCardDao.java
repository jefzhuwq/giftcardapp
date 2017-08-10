package com.mediabox.giftcardapp.dao;

import com.mediabox.giftcardapp.model.GiftCard;
import com.mediabox.giftcardapp.model.User;

import java.util.List;

/**
 * Created by jeffe on 7/6/2017.
 */
public interface GiftCardDao {

    void add(GiftCard card);

    void edit(GiftCard card);

    void delete(String cardID);

    List<GiftCard> findGiftCardByUserId(String userID);

    GiftCard getGiftCard(String cardID);
}
