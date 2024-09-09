package com.myprojectspringboot.pointofsale.controller;


import com.myprojectspringboot.pointofsale.dto.CustomerDTO;
import com.myprojectspringboot.pointofsale.dto.request.ItemSaveRequestDTO;
import com.myprojectspringboot.pointofsale.dto.response.ItemGetResponse;
import com.myprojectspringboot.pointofsale.entity.Item;
import com.myprojectspringboot.pointofsale.service.itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private itemService itemService;

    @PostMapping("/save")
    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {

      String message=  itemService.saveItem(itemSaveRequestDTO);
        return "saved";
    }

    @GetMapping(path="/get-item-by-name",params="name")
    public List<ItemGetResponse> getItemByName(@RequestParam(value="name") String name){
            List<ItemGetResponse> items=itemService.getItemByNameAndStatus(name);
          return items;
    }
}
