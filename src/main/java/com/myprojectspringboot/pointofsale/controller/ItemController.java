package com.myprojectspringboot.pointofsale.controller;


import com.myprojectspringboot.pointofsale.dto.CustomerDTO;
import com.myprojectspringboot.pointofsale.dto.request.ItemSaveRequestDTO;
import com.myprojectspringboot.pointofsale.dto.response.ItemGetResponse;
import com.myprojectspringboot.pointofsale.entity.Item;
import com.myprojectspringboot.pointofsale.service.itemService;
import com.myprojectspringboot.pointofsale.utills.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private itemService itemService;

//    @PostMapping("/save")
//    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
//
//      String message=  itemService.saveItem(itemSaveRequestDTO);
//        return "saved";
//    }

    @PostMapping("/save")
    public ResponseEntity<StandardResponse>saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {

        String message=  itemService.saveItem(itemSaveRequestDTO);
         ResponseEntity<StandardResponse> response=new ResponseEntity<StandardResponse>(new StandardResponse(201,"success",message), HttpStatus.CREATED);
        return  response;
    }

    @GetMapping(path="/get-item-by-name",params="name")
    public List<ItemGetResponse> getItemByName(@RequestParam(value="name") String name){
            List<ItemGetResponse> items=itemService.getItemByNameAndStatus(name);
          return items;
    }

    @GetMapping(path="/get-all-item-by-status",params="activeState")
    public ResponseEntity<StandardResponse> getItemByActiveStatus(@RequestParam(value="activeState") boolean activeState){
        List<ItemGetResponse> activeItems=itemService.getItemsbyActiveState(activeState);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",activeItems),
                HttpStatus.OK
        );
    }
}
