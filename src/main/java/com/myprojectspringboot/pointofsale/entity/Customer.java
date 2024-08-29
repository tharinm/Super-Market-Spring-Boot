package com.myprojectspringboot.pointofsale.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Array;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;

@Entity
@Table(name="customer")

public class Customer {

    @Id //primary key
    @Column (name="customer_id",length = 45)  //column name
    private int customerId;


    @Column( name="customer_name",length = 100,nullable = false)
    private String customerName;


    @Column(name="customer_address",length = 255)
    private String customerAddress;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name="contact_numbers",length = 255,columnDefinition = "json")
    private ArrayList contactNumber;

    @Column(name="customer_salary")
    private int customerSalary;

    @Column(name="customer_nic",length = 255)
    private String nic;


    @Column(name="customer_status",columnDefinition = "TINYINT default 1")
    private boolean active;
}
