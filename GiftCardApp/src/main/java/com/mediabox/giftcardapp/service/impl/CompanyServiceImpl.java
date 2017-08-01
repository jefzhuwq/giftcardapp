package com.mediabox.giftcardapp.service.impl;

import com.mediabox.giftcardapp.model.User;
import com.mediabox.giftcardapp.service.CompanyService;
import com.mediabox.giftcardapp.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jeffe on 7/6/2017.
 */
@Component
public class CompanyServiceImpl implements CompanyService {
    @Override
    @Transactional
    public void add(User user) {

    }
}
