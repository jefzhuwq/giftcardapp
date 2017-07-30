package com.mediabox.giftcardapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jeffe on 7/8/2017.
 */
@Data
@Entity
@Table(name="redeemhistory")//, catalog = "giftcarddb")
public class RedeemHistory {
    @Id
    @Column(name = "history_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String historyID;

    @Column(name = "giftcard_id")
    private String giftcardID;

    @Column(name = "user_id")
    private String userID;

    @Column(name = "create_timestamp")
    private Date createTimestamp;

    @Column(name = "update_timestamp")
    private Date updateTimestamp;
}
