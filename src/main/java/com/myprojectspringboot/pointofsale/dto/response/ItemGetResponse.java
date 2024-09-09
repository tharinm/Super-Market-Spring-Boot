package com.myprojectspringboot.pointofsale.dto.response;

import com.myprojectspringboot.pointofsale.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemGetResponse {
    private int itemId;
    private String itemName;
    private MeasuringUnitType measuringType;
    private double QTY;
    private double supplierPrice;
    private double sellingPrice;
    private boolean activeState;
}
