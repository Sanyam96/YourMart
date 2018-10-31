package com.nagarro.yourmart.service;

import com.nagarro.yourmart.domains.Seller;
import com.nagarro.yourmart.domains.SellerStatus;
import com.nagarro.yourmart.dtos.SellerRequest;
import com.nagarro.yourmart.dtos.SellerResponse;
import com.nagarro.yourmart.enums.SellerStatusEnum;
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

    @Autowired
    SellerStatusService sellerStatusService;

    @Transactional
    public List<SellerResponse> getAllSellers() {
        List<Seller> sellerList = sellerRepository.getList(Seller.class);
        List<SellerResponse> sellerResponseList = Utility.convertModelList(sellerList, SellerResponse.class);

        for (long i = 0; i < sellerResponseList.size(); i++) {

            if(sellerResponseList.get((int) i).getSellerStatusId() == 1) {
                sellerResponseList.get((int) i).setSellerStatus(SellerStatusEnum.NEED_APPROVAL);
            } else if(sellerResponseList.get((int) i).getSellerStatusId() == 2) {
                sellerResponseList.get((int) i).setSellerStatus(SellerStatusEnum.NON_REGISTERED);
            } else {
                sellerResponseList.get((int) i).setSellerStatus(SellerStatusEnum.REJECTED);
            }


//            sellerResponseList.get(0).setSellerStatus(SellerStatusEnum.NEED_APPROVAL);
        }

        if(sellerResponseList == null || sellerList.isEmpty()) {
            throw new YourMartResourceNotFoundException("Seller List not found");
        }

        return sellerResponseList;
    }

    @Transactional
    public SellerResponse getSellerById(long id) {
        Seller seller = sellerRepository.getById(id, Seller.class);
        SellerResponse sellerResponse = Utility.convertModel(seller, SellerResponse.class);

        if(sellerResponse.getSellerStatusId() == 1) {
            sellerResponse.setSellerStatus(SellerStatusEnum.NEED_APPROVAL);
        } else if(sellerResponse.getSellerStatusId() == 2) {
            sellerResponse.setSellerStatus(SellerStatusEnum.NON_REGISTERED);
        } else {
            sellerResponse.setSellerStatus(SellerStatusEnum.REJECTED);
        }

        if(sellerResponse == null || seller == null) {
            throw new YourMartResourceNotFoundException("Seller not found with the given id: " + id);
        }
        return sellerResponse;
    }

    @Transactional
    public String createSeller(SellerRequest sellerRequest) {

        // db call
        Seller seller = new Seller();

        seller.setCompanyName(sellerRequest.getCompanyName());
        seller.setOwnerName(sellerRequest.getOwnerName());
        seller.setAddress(sellerRequest.getAddress());
        seller.setEmailAddress(sellerRequest.getEmailAddress());
        seller.setTelephoneNumber(sellerRequest.getTelephoneNumber());
        seller.setGstNumber(sellerRequest.getGstNumber());
        seller.setPassword(sellerRequest.getPassword());

        // by default status to 1
        seller.setSellerStatus(sellerStatusService.getSellerStatusById(1));
//        System.out.println("done-half");

        sellerRepository.create(seller);
//        System.out.println("done");

        return "created";
    }
}
