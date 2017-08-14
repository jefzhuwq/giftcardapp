package com.mediabox.giftcardapp.service.impl;

import com.mediabox.giftcardapp.dao.CompanyDao;
import com.mediabox.giftcardapp.dao.GiftCardDao;
import com.mediabox.giftcardapp.model.Company;
import com.mediabox.giftcardapp.model.GiftCard;
import com.mediabox.giftcardapp.model.User;
import com.mediabox.giftcardapp.service.GiftCardService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jeffe on 7/6/2017.
 */
@Component
public class GiftCardServiceImpl implements GiftCardService {

    @Autowired
    private GiftCardDao giftCardDao;

    @Autowired
    private CompanyDao companyDao;

    @Override
    @Transactional
    public void add(GiftCard card) {
        this.giftCardDao.add(card);
    }

    @Override
    @Transactional
    public void delete(String cardID) {
        giftCardDao.delete(cardID);
    }

    @Override
    @Transactional
    public List<GiftCard> findGiftCardByUserID(String userID) {
        return giftCardDao.findGiftCardByUserId(userID);
    }

    @Override
    @Transactional
    public GiftCard getGiftCard(String cardID) {
        return giftCardDao.getGiftCard(cardID);
    }

    @Override
    @Transactional
    public Set<Company> getAllCompanyOnUserGiftCard(String userID) {
        List<GiftCard> giftCardList = this.findGiftCardByUserID(userID);
        Set<Company> result = new HashSet<>();
        for (GiftCard card : giftCardList) {
            if (card.getCompanyID() != null && !result.contains(card.getCompanyID())) {
                Company company = companyDao.getCompany(card.getCompanyID());
                result.add(company);
            }
        }
        return result;
    }
}
