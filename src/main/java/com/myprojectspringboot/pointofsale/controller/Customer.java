package com.myprojectspringboot.pointofsale.controller;

import com.myprojectspringboot.pointofsale.dto.CustomerDTO;
import com.myprojectspringboot.pointofsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class Customer {

    //depenenci enject
    @Autowired
    private CustomerService customerService;

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
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
        String save=customerDTO.getCustomerName();
        System.out.println(" "+save);
        customerService.saveCustomer(customerDTO);
        return save;
    }

}
