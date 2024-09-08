package com.myprojectspringboot.pointofsale.controller;


import com.myprojectspringboot.pointofsale.dto.request.ItemSaveRequestDTO;
import com.myprojectspringboot.pointofsale.service.itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
