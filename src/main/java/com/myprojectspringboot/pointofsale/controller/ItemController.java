package com.myprojectspringboot.pointofsale.controller;


import com.myprojectspringboot.pointofsale.service.CustomerService;
import com.myprojectspringboot.pointofsale.service.itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private itemService itemService;


}
