package com.myprojectspringboot.pointofsale.dto.request;


import com.myprojectspringboot.pointofsale.entity.Item;
import com.myprojectspringboot.pointofsale.entity.Orders;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrderDetailsSaveDTO {




    private String itemName;
    private double quantity;
    private double unitPrice;
    private double totalPrice;
    private int items;

}
