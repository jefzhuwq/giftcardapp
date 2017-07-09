package com.mediabox.giftcardapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jeffe on 7/8/2017.
 */
@Data
@Entity
@Table(name="redeemhistory", catalog = "giftcardapp")
public class RedeemHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String historyID;

    @Column
    private String cardID;

    @Column
    private Boolean userID;

    @Column
    private Date createTimestamp;

    @Column
    private Date updateTimestamp;
}
