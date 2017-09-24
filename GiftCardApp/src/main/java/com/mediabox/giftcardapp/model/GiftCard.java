package com.mediabox.giftcardapp.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jeffe on 7/6/2017.
 */
@Data
@Entity
@Table(name="giftcard") //catalog = "giftcarddb")
public class GiftCard {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "giftcard_id")
    private String giftcardID;

    @Column(name = "user_id")
    private String userID;

    @Column(name = "company_id")
    private String companyID;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_pin")
    private String cardPin;

    @Column(name = "remaining_credit")
    private double remainingCredit;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

    @Column(name = "expiration_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;

    @Column(name = "create_timestamp")
    private Date createTimestamp;

    @Column(name = "update_timestamp")
    private Date updateTimestamp;

    @Column(name = "is_for_sale")
    private Boolean isForSale;

    @Column(name = "sales_price")
    private Double salesPrice;
}
