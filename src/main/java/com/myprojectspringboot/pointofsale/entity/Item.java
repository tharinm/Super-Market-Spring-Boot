package com.myprojectspringboot.pointofsale.entity;


import com.myprojectspringboot.pointofsale.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "item")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Item {

    @Id //primary key
    @Column(name="item_id",length = 45)  //column name
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column( name="item_name",length = 100,nullable = false)
    private String itemName;


    //ENUM Class
    @Enumerated(EnumType.STRING)
    @Column( name="measure_type",length = 100,nullable = false)
    private MeasuringUnitType measuringType;

    @Column( name="balance_qty",length = 100,nullable = false)
    private double QTY;

    @Column( name="supplier_price",length = 100,nullable = false)
    private double supplierPrice;

    @Column( name="selling_price",length = 100,nullable = false)
    private double sellingPrice;

    @Column(name="active_status",columnDefinition = "TINYINT default 1")
    private boolean activeState;


}
