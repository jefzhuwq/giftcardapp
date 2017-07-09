package com.mediabox.giftcardapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jeffe on 7/8/2017.
 */
@Data
@Entity
@Table(name="company", catalog = "giftcardapp")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String companyID;

    @Column
    private String companyName;

    @Column
    private Boolean isPublic;

    @Column
    private Date createTimestamp;

    @Column
    private Date updateTimestamp;
}
