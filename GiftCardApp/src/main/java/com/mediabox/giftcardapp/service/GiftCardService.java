package com.mediabox.giftcardapp.service;

import com.mediabox.giftcardapp.model.GiftCard;
import com.mediabox.giftcardapp.model.User;

import java.util.List;

/**
 * Created by jeffe on 7/6/2017.
 */
public interface GiftCardService {

    void add(GiftCard card);

    void delete(String cardID);

    List<GiftCard> findGiftCardByUserID(String userID);

    GiftCard getGiftCard(String cardID);
}
