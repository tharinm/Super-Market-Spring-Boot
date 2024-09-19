package com.myprojectspringboot.pointofsale.service.impl;

import com.myprojectspringboot.pointofsale.dto.request.RequestOrderSaveDTO;
import com.myprojectspringboot.pointofsale.dto.response.ItemGetResponse;
import com.myprojectspringboot.pointofsale.entity.Customer;
import com.myprojectspringboot.pointofsale.entity.OrderDetails;
import com.myprojectspringboot.pointofsale.entity.Orders;
import com.myprojectspringboot.pointofsale.repo.CustomerRepo;
import com.myprojectspringboot.pointofsale.repo.ItemRepo;
import com.myprojectspringboot.pointofsale.repo.OrderDetailRepo;
import com.myprojectspringboot.pointofsale.repo.OrderRepo;
import com.myprojectspringboot.pointofsale.service.OrderService;
import jakarta.transaction.Transactional;
import org.hibernate.query.Order;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private ItemRepo itemRepo;

    //handle the transactions
    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {

        //fetch customer here
        Customer customer = customerRepo.getReferenceById(requestOrderSaveDTO.getCustomer());
        System.out.println("___" +customer);

        Orders orders = new Orders(customer, requestOrderSaveDTO.getDate(), requestOrderSaveDTO.getTotal());
        System.out.println("_____" +orders);
        orderRepo.save(orders);
        System.out.println("______________________" + orders);

        if(orderRepo.existsById(orders.getOrderId())){

            List<OrderDetails> orderDetails=modelMapper.map(requestOrderSaveDTO.getOrderDetails(),new TypeToken<List<OrderDetails>>(){}.getType());

            for(int i=0;i<orderDetails.size();i++){
                orderDetails.get(i).setOrders(orders);
                orderDetails.get(i).setItem(itemRepo.getReferenceById(requestOrderSaveDTO.getOrderDetails().get(i).getItems()));
            }

            if(!orderDetails.isEmpty()){
                orderDetailRepo.saveAll(orderDetails);
            }
            return "saved";
        }

        return  null;

    }
}