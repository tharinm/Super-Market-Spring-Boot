package com.myprojectspringboot.pointofsale.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {


    @Id
    @Column(name="order_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;


}
