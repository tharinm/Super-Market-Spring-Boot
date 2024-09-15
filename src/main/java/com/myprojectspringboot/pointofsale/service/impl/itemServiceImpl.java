package com.myprojectspringboot.pointofsale.service.impl;

import com.myprojectspringboot.pointofsale.dto.request.ItemSaveRequestDTO;
import com.myprojectspringboot.pointofsale.dto.response.ItemGetResponse;
import com.myprojectspringboot.pointofsale.entity.Customer;
import com.myprojectspringboot.pointofsale.entity.Item;
import com.myprojectspringboot.pointofsale.entity.enums.MeasuringUnitType;
import com.myprojectspringboot.pointofsale.exception.NotFoundException;
import com.myprojectspringboot.pointofsale.paginated.PaginatedResponseItemDTO;
import com.myprojectspringboot.pointofsale.repo.ItemRepo;
import com.myprojectspringboot.pointofsale.service.itemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import java.util.List;


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

    @Override
    public List<ItemGetResponse> getItemByNameAndStatus(String name) {
        boolean b=true;
        List <Item> items=itemRepo.findAllByItemNameEqualsAndActiveStateEquals(name,b);
        if(items.size()>0){
            //special thing in modelwrapper list
            List <ItemGetResponse> itemGetResponses=modelMapper.map(items,new TypeToken<List<ItemGetResponse>>(){}.getType());
            return itemGetResponses;
        }
        else{
            throw new RuntimeException("Item Not Active");
        }
    }

    @Override
    public List<ItemGetResponse> getItemsbyActiveState(boolean activeState) {
        List <Item> items=itemRepo.findAllByActiveStateEquals(activeState);
        if(items.size()>0){
            //special thing in modelwrapper list
            List <ItemGetResponse> itemGetResponses=modelMapper.map(items,new TypeToken<List<ItemGetResponse>>(){}.getType());
            return itemGetResponses;
        }
        else{
            throw new NotFoundException("Item Not Active");
        }
    }

    @Override
    public PaginatedResponseItemDTO getItemsbyActiveStatePaginate(boolean activeState, int page, int size) {
        Page<Item> items = itemRepo.findAllByActiveStateEquals(activeState, PageRequest.of(page, size));

        if(items.hasContent()) { // Check if there is content
            // Mapping list of Item to List<ItemGetResponse>
            List<ItemGetResponse> itemList = modelMapper.map(items.getContent(), new TypeToken<List<ItemGetResponse>>(){}.getType());

            // Create PaginatedResponseItemDTO object
            PaginatedResponseItemDTO paginatedResponseItemDTO = new PaginatedResponseItemDTO();
            paginatedResponseItemDTO.setActiveItems(itemList); // Set active items
            paginatedResponseItemDTO.setDataCount(items.getTotalElements()); // Set total data count

            return paginatedResponseItemDTO;
        } else {
            throw new NotFoundException("No data found");
        }
    }

}


