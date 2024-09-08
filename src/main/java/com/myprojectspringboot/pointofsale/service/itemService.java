package com.myprojectspringboot.pointofsale.service;

import com.myprojectspringboot.pointofsale.dto.request.ItemSaveRequestDTO;

public interface itemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);
}
