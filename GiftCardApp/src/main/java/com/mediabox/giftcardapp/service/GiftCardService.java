package com.mediabox.giftcardapp.service;

import com.mediabox.giftcardapp.model.Company;
import com.mediabox.giftcardapp.model.GiftCard;
import com.mediabox.giftcardapp.model.User;

import java.util.List;
import java.util.Set;

/**
 * Created by jeffe on 7/6/2017.
 */
public interface GiftCardService {

    void add(GiftCard card);

    void delete(String cardID);

    List<GiftCard> findGiftCardByUserID(String userID);

    GiftCard getGiftCard(String cardID);

    Set<Company> getAllCompanyOnUserGiftCard(String userID);
}
