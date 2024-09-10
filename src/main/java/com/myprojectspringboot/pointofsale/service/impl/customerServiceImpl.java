package com.myprojectspringboot.pointofsale.service.impl;

import com.myprojectspringboot.pointofsale.dto.CustomerDTO;
import com.myprojectspringboot.pointofsale.dto.request.CustomerUpdateDTO;
import com.myprojectspringboot.pointofsale.entity.Customer;
import com.myprojectspringboot.pointofsale.repo.CustomerRepo;
import com.myprojectspringboot.pointofsale.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service



public class customerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        //this is  constructor only no object
//        Customer customer=new Customer(
//                customerDTO.getCustomerId(),
//                customerDTO.getCustomerName(),
//                customerDTO.getCustomerAddress(),
//                customerDTO.getContactNumber(),
//                customerDTO.getCustomerSalary(),
//                customerDTO.getNic(),
//                customerDTO.isActive()
//        );

        Customer customer=modelMapper.map(customerDTO,Customer.class);


        customerRepo.save(customer);
        System.out.println("address " +customerDTO.getCustomerAddress());
        return "";
    }

    @Override
    public String  updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
            if(customerRepo.existsById(customerUpdateDTO.getCustomerId())){
                        Customer customer=customerRepo.getReferenceById((customerUpdateDTO.getCustomerId()));


//                        customer.setCustomerName(customerUpdateDTO.getCustomerName());
//                        customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
//                        customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());
                modelMapper.map(customerUpdateDTO, customer);

                        customerRepo.save(customer);
                        return customerUpdateDTO.getCustomerName() + " update success";

            }
            else{
                    throw new RuntimeException("no data");
            }
    }

    @Override
    public CustomerDTO getCustomerById(int id) {
       if(customerRepo.existsById(id))
       {
           Customer customer=customerRepo.getReferenceById(id);


//           CustomerDTO customerDTO=new CustomerDTO(
//                   customer.getCustomerId(),
//                   customer.getCustomerName(),
//                   customer.getCustomerAddress(),
//                   customer.getContactNumber(),
//                   customer.getCustomerSalary(),
//                   customer.getNic(),
//                   customer.isActive()
//           );

           CustomerDTO customerDTO=modelMapper.map(customer,CustomerDTO.class);
           return customerDTO;

       }
       else{
           throw new RuntimeException("no data");
       }


    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List <Customer> getAllCustomers=customerRepo.findAll();

        List <CustomerDTO> customerDTOList=new ArrayList<>();

      for(Customer customer:getAllCustomers){
//          CustomerDTO customerDTO=new CustomerDTO(
//                  customer.getCustomerId(),
//                  customer.getCustomerName(),
//                  customer.getCustomerAddress(),
//                  customer.getContactNumber(),
//                  customer.getCustomerSalary(),
//                  customer.getNic(),
//                  customer.isActive()
//          );

          CustomerDTO customerDTO=modelMapper.map(customer,CustomerDTO.class);
          customerDTOList.add(customerDTO);
      }
        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {

            if(customerRepo.existsById((customerId))){
                customerRepo.deleteById(customerId);
                return "Deleted Successfully " +customerId;
            }
            else{
                throw new RuntimeException("no customer to delete");
            }

    }

    @Override
    public List<CustomerDTO> getAllCustomersByActive(boolean activeState) {
        List <Customer> getAllCustomers=customerRepo.findAllByActiveEquals(activeState);

        List <CustomerDTO> customerDTOList=new ArrayList<>();

        for(Customer customer:getAllCustomers){
//            CustomerDTO customerDTO=new CustomerDTO(
//                    customer.getCustomerId(),
//                    customer.getCustomerName(),
//                    customer.getCustomerAddress(),
//                    customer.getContactNumber(),
//                    customer.getCustomerSalary(),
//                    customer.getNic(),
//                    customer.isActive()
//            );
            CustomerDTO customerDTO=modelMapper.map(customer,CustomerDTO.class);
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }
}
