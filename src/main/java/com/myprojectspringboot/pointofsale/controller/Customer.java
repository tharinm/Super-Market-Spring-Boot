package com.myprojectspringboot.pointofsale.controller;

import com.myprojectspringboot.pointofsale.dto.CustomerDTO;
import com.myprojectspringboot.pointofsale.dto.request.CustomerUpdateDTO;
import com.myprojectspringboot.pointofsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
//        String save=customerDTO.getCustomerName();
//        System.out.println(" "+save);
        customerService.saveCustomer(customerDTO);
        return "saved";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerDTO){
           String message= customerService.updateCustomer(customerDTO);
            return message;
    }

    //using params
    @GetMapping(path="/get-by-id",params = "id")
    public CustomerDTO getCustomerById(@RequestParam(value="id") int id){
     CustomerDTO customerDTO=customerService.getCustomerById(id);
        return customerDTO;
    }


    @GetMapping("/get-all-customer")
    public List<CustomerDTO> getAllCustomers(){
       List <CustomerDTO> allCustomers=customerService.getAllCustomers()
;        return  allCustomers;
    }


    //pathvaribale
    @DeleteMapping(path = "/delete-customer/{id}")
    public String deletCustomer(@PathVariable(value="id") int customerId){
            String delete=customerService.deleteCustomer(customerId);
            return delete;
    }

    @GetMapping("/get-all-by-active/{status}")
    public List<CustomerDTO> getAllCustomersByActive(@PathVariable(value="status") boolean activeState){
        List <CustomerDTO> allCustomers=customerService.getAllCustomersByActive(activeState);
        return  allCustomers;
    }

}
