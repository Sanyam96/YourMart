package com.nagarro.yourmart.service;

import com.nagarro.yourmart.domains.SellerStatus;
import com.nagarro.yourmart.repository.SellerStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sanyam Goel created on 31/10/18
 */
@Service
public class SellerStatusService {

    @Autowired
    SellerStatusRepository sellerStatusRepository;

    @Transactional
    public SellerStatus getSellerStatusById(long id) {
        SellerStatus sellerStatus = sellerStatusRepository.getById(id, SellerStatus.class);
//        SellersDTO sellerDTO = Utility.convertModel(seller, SellersDTO.class);

//        if(sellerDTO == null || seller == null) {
//            throw new YourMartResourceNotFoundException("Seller not found with the given id: " + id);
//        }
        return sellerStatus;
    }
}
