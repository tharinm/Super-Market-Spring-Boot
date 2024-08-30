package com.myprojectspringboot.pointofsale.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class Customer {


    @GetMapping("/get-text-1")
    public String getMyTest(){
        String myTest="This is cus 1";
        System.out.println(" "+myTest);
        return myTest;
    }

    @GetMapping("/get-text-2")
    public String  getMyTest2(){
        String myTest="This is cus 2";
        System.out.println(" "+myTest);
        return myTest;
    }

    @PostMapping("/save")
    public String saveCustomer() {
        String save="Customer Saved";
        System.out.println(" "+save);
        return save;
    }

}
