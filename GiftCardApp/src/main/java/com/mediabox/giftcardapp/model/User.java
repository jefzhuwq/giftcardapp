package com.mediabox.giftcardapp.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jeffe on 7/6/2017.
 */
@Data
@Entity
@Table(name="user", catalog = "giftcardapp")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userID;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String password;

    @Column
    private Boolean isEnabled;

    @Column
    private String email;

    @Column
    private Date createTimestamp;

    @Column
    private Date updateTimestamp;
}