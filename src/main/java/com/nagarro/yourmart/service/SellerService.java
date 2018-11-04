package com.nagarro.yourmart.service;

import com.nagarro.yourmart.domains.Seller;
import com.nagarro.yourmart.domains.SellerStatus;
import com.nagarro.yourmart.dtos.SellerLoginRequest;
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
    public List<SellerResponse> getAllSellers(Long offset, Long limit) {
//        List<Seller> sellerList = sellerRepository.getList(Seller.class);
        List<Seller> sellerList = sellerRepository.getSellersPaginatedResult(offset, limit);
        List<SellerResponse> sellerResponseList = Utility.convertModelList(sellerList, SellerResponse.class);

        for (long i = 0; i < sellerResponseList.size(); i++) {
            if(sellerResponseList.get((int) i).getSellerStatusId() == 1) {
                sellerResponseList.get((int) i).setSellerStatus(SellerStatusEnum.NEED_APPROVAL);
            } else if(sellerResponseList.get((int) i).getSellerStatusId() == 2) {
                sellerResponseList.get((int) i).setSellerStatus(SellerStatusEnum.NON_REGISTERED);
            } else if(sellerResponseList.get((int) i).getSellerStatusId() == 3) {
                sellerResponseList.get((int) i).setSellerStatus(SellerStatusEnum.REJECTED);
            } else if(sellerResponseList.get((int) i).getSellerStatusId() == 4) {
                sellerResponseList.get((int) i).setSellerStatus(SellerStatusEnum.APPROVED);
            }
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
        } else if(sellerResponse.getSellerStatusId() == 3){
            sellerResponse.setSellerStatus(SellerStatusEnum.REJECTED);
        } else if(sellerResponse.getSellerStatusId() == 4) {
            sellerResponse.setSellerStatus(SellerStatusEnum.APPROVED);
        }

        if(sellerResponse == null || seller == null) {
            throw new YourMartResourceNotFoundException("Seller not found with the given id: " + id);
        }
        return sellerResponse;
    }

    @Transactional
    public SellerResponse createSeller(SellerRequest sellerRequest) {

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

        SellerResponse sellerResponse = Utility.convertModel(sellerRequest, SellerResponse.class);
        sellerResponse.setSellerStatus(SellerStatusEnum.NEED_APPROVAL);
        sellerResponse.setSellerStatusId(seller.getSellerStatus().getId());
        sellerResponse.setId(seller.getId());
        sellerResponse.setCreatedAt(seller.getCreatedAt());
        sellerResponse.setUpdatedAt(seller.getUpdatedAt());

        return sellerResponse;
//        return "created";
    }

    @Transactional
    public SellerResponse updateSeller(SellerRequest sellerRequest, Long sellerId) {
        Seller seller = sellerRepository.getById(sellerId, Seller.class);

        if(seller == null) {
            throw new YourMartResourceNotFoundException("Seller not found with the given id: " + sellerId);
        }

        seller.setCompanyName(sellerRequest.getCompanyName());
        seller.setOwnerName(sellerRequest.getOwnerName());
        seller.setAddress(sellerRequest.getAddress());
        seller.setEmailAddress(sellerRequest.getEmailAddress());
        seller.setTelephoneNumber(sellerRequest.getTelephoneNumber());
        seller.setGstNumber(sellerRequest.getGstNumber());

        if(sellerRequest.getPassword() != null) {
            seller.setPassword(sellerRequest.getPassword());
        }

        seller.setSellerStatus(sellerStatusService.getSellerStatusById(1));
        sellerRepository.update(seller);

        SellerResponse sellerResponse = Utility.convertModel(sellerRequest, SellerResponse.class);
        sellerResponse.setSellerStatus(SellerStatusEnum.NEED_APPROVAL);
        sellerResponse.setSellerStatusId(seller.getSellerStatus().getId());
        sellerResponse.setId(seller.getId());
        sellerResponse.setCreatedAt(seller.getCreatedAt());
        sellerResponse.setUpdatedAt(seller.getUpdatedAt());
        return sellerResponse;
    }


    @Transactional
    public Seller getSellerId(long id) {
        Seller seller = sellerRepository.getById(id, Seller.class);
        return seller;
    }

    @Transactional
    public String checkUser(SellerLoginRequest sellerlogin) {
        Seller seller = sellerRepository.getSellerStatus(sellerlogin.getId(), sellerlogin.getPassword());
        if(seller == null) {
            return "false";
        } else {
            if(seller.getSellerStatusId() == 1) {
                System.out.println("NEED_APPROVAL");
                System.out.println(SellerStatusEnum.NEED_APPROVAL);
                return "NEED_APPROVAL";
            } else if(seller.getSellerStatusId() == 2) {
                System.out.println("NON_REGISTERED");
                System.out.println(SellerStatusEnum.NON_REGISTERED);
                return "NON_REGISTERED";
            } else if(seller.getSellerStatusId() == 3   ) {
                System.out.println("REJECTED");
                System.out.println(SellerStatusEnum.REJECTED);
                return "REJECTED";
            } else if(seller.getSellerStatusId() == 4) {
                System.out.println("APPROVED");
                System.out.println(SellerStatusEnum.APPROVED);
                return "APPROVED";
            }
        }
        return "notKnown";
    }

    @Transactional
    public String updateSellerStatus(long id) {

        Seller seller = sellerRepository.getById(id, Seller.class);

//        4 for Approved
        seller.setSellerStatus(sellerStatusService.getSellerStatusById(4));

        sellerRepository.update(seller);

        return "updated";
    }
}
