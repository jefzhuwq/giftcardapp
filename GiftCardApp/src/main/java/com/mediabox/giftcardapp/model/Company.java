package com.mediabox.giftcardapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jeffe on 7/8/2017.
 */
@Data
@Entity
@Table(name="company")//, catalog = "giftcarddb")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private String companyID;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "is_public")
    private Boolean isPublic;

    @Column(name = "create_timestamp")
    private Date createTimestamp;

    @Column(name = "update_timestamp")
    private Date updateTimestamp;
}
