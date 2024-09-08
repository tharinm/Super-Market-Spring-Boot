package com.myprojectspringboot.pointofsale.service.impl;

import com.myprojectspringboot.pointofsale.dto.request.ItemSaveRequestDTO;
import com.myprojectspringboot.pointofsale.entity.Customer;
import com.myprojectspringboot.pointofsale.entity.Item;
import com.myprojectspringboot.pointofsale.entity.enums.MeasuringUnitType;
import com.myprojectspringboot.pointofsale.repo.ItemRepo;
import com.myprojectspringboot.pointofsale.service.itemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;


@Service
public class itemServiceImpl implements itemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
//        Item item=new Item(
//               1,
//                itemSaveRequestDTO.getItemName(),
//                itemSaveRequestDTO.getMeasuringType(),
//                itemSaveRequestDTO.getQTY(),
//                itemSaveRequestDTO.getSupplierPrice(),
//                itemSaveRequestDTO.getSellingPrice(),
//                true
//        );


        Item item  =modelMapper.map(itemSaveRequestDTO,Item.class);

        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return item.getItemName() + "Saved Item successfully";
        }
        else {
            throw new RuntimeException("Already Insert");
        }
    }
}


