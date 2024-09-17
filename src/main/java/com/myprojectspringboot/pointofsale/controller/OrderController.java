package com.myprojectspringboot.pointofsale.controller;


import com.myprojectspringboot.pointofsale.dto.request.ItemSaveRequestDTO;
import com.myprojectspringboot.pointofsale.dto.request.RequestOrderSaveDTO;
import com.myprojectspringboot.pointofsale.utills.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/order")
public class OrderController {

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO) {
        System.out.println(requestOrderSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"",2),
                HttpStatus.CREATED
        );

    }
}
