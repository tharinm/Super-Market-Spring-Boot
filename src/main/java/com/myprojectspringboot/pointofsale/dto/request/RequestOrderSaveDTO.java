package com.myprojectspringboot.pointofsale.dto.request;

import com.myprojectspringboot.pointofsale.entity.Customer;
import com.myprojectspringboot.pointofsale.entity.OrderDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrderSaveDTO {

    private int customer;
    private Date date;
    private Double total;
    private List<RequestOrderDetailsSaveDTO> orderDetails;
}
