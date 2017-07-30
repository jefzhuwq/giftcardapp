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
@Table(name="user", catalog = "giftcarddb")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

    @Column(name = "email")
    private String email;

    @Column(name = "create_timestamp")
    private Date createTimestamp;

    @Column(name = "update_timestamp")
    private Date updateTimestamp;
}
