package com.myprojectspringboot.pointofsale.service;

import com.myprojectspringboot.pointofsale.dto.request.RequestOrderSaveDTO;

public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);
}
