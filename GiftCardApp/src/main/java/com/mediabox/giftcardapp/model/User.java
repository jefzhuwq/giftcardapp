package com.mediabox.giftcardapp.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

/**
 * Created by jeffe on 7/6/2017.
 */
@Data
@Entity
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userID;

    @Column
    private String firstName;

    @Column
    private String lastName;
}
