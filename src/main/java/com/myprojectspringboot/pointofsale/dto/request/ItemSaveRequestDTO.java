package com.myprojectspringboot.pointofsale.dto.request;


import com.myprojectspringboot.pointofsale.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemSaveRequestDTO {


    private String itemName;
    private MeasuringUnitType measuringType;
    private double QTY;
    private double supplierPrice;
    private double sellingPrice;


}
