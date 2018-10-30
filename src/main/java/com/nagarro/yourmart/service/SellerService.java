package com.nagarro.yourmart.service;

import com.nagarro.yourmart.domains.Seller;
import com.nagarro.yourmart.dtos.SellersDTO;
import com.nagarro.yourmart.exceptions.YourMartResourceNotFoundException;
import com.nagarro.yourmart.repository.SellerRepository;
import com.nagarro.yourmart.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Sanyam Goel created on 30/10/18
 */
@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Transactional
    public List<SellersDTO> getAllSellers() {
        List<Seller> sellerList = sellerRepository.getList(Seller.class);
        List<SellersDTO> sellersDTOList = Utility.convertModelList(sellerList, SellersDTO.class);

        if(sellersDTOList == null || sellerList.isEmpty()) {
            throw new YourMartResourceNotFoundException("Seller List not found");
        }

        return sellersDTOList;
    }

    @Transactional
    public SellersDTO getSellerById(long id) {
        Seller seller = sellerRepository.getById(id, Seller.class);
        SellersDTO sellerDTO = Utility.convertModel(seller, SellersDTO.class);

        if(sellerDTO == null || seller == null) {
            throw new YourMartResourceNotFoundException("Seller not found with the given id: " + id);
        }
        return sellerDTO;
    }
}
