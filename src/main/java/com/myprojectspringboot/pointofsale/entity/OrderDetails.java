package com.myprojectspringboot.pointofsale.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetails {

    @Id
    @Column(name="order_details_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailsId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(name = "quantity", nullable = false)
    private double quantity;

    @Column(name = "unit_price", nullable = false)
    private double unitPrice;

    @Column(name = "total_price", nullable = false)
    private double totalPrice;
}
