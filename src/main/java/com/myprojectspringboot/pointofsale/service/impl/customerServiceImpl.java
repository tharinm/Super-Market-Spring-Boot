package com.myprojectspringboot.pointofsale.service.impl;

import com.myprojectspringboot.pointofsale.dto.CustomerDTO;
import com.myprojectspringboot.pointofsale.dto.request.CustomerUpdateDTO;
import com.myprojectspringboot.pointofsale.entity.Customer;
import com.myprojectspringboot.pointofsale.repo.CustomerRepo;
import com.myprojectspringboot.pointofsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service



public class customerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        //this is  constructor only no object
        Customer customer=new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getContactNumber(),
                customerDTO.getCustomerSalary(),
                customerDTO.getNic(),
                customerDTO.isActive()
        );


        customerRepo.save(customer);
        System.out.println("address " +customerDTO.getCustomerAddress());
        return "";
    }

    @Override
    public String  updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
            if(customerRepo.existsById(customerUpdateDTO.getCustomerId())){
                        Customer customer=customerRepo.getReferenceById((customerUpdateDTO.getCustomerId()));
                        customer.setCustomerName(customerUpdateDTO.getCustomerName());
                        customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
                        customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

                        customerRepo.save(customer);
                        return customerUpdateDTO.getCustomerName() + "update success";

            }
            else{
                    throw new RuntimeException("no data");
            }
    }
}
