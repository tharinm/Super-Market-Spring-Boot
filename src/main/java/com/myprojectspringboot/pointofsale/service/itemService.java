package com.myprojectspringboot.pointofsale.service;

import com.myprojectspringboot.pointofsale.dto.request.ItemSaveRequestDTO;
import com.myprojectspringboot.pointofsale.dto.response.ItemGetResponse;
import com.myprojectspringboot.pointofsale.paginated.PaginatedResponseItemDTO;

import java.util.List;

public interface itemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponse> getItemByNameAndStatus(String name);

    List<ItemGetResponse> getItemsbyActiveState(boolean activeState);

    PaginatedResponseItemDTO getItemsbyActiveStatePaginate(boolean activeState, int page, int size);
}
