package com.mediabox.giftcardapp.config;

import com.mediabox.giftcardapp.model.User;
import com.mediabox.giftcardapp.service.UserService;
import com.mediabox.giftcardapp.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }

//    @Bean
//    public User user() {
//        return new User();
//    }
}
