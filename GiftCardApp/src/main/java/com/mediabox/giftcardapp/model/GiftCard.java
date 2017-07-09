package com.mediabox.giftcardapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jeffe on 7/6/2017.
 */
@Data
@Entity
@Table(name="giftcard", catalog = "giftcardapp")
public class GiftCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String cardID;

    @Column
    private String userID;

    @Column
    private String companyID;

    @Column
    private String cardNumber;

    @Column
    private String cardPin;

    @Column
    private double remainCredit;

    @Column
    private Boolean isEnabled;

    @Column
    private Date expirationDate;

    @Column
    private Date createTimestamp;

    @Column
    private Date updateTimestamp;
}
