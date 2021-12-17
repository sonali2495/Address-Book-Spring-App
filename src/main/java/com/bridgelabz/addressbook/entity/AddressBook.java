package com.bridgelabz.addressbook.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;

    @Column(unique = true)
    private String phoneNumber;

    private String email;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date UpdatedOn;
}
