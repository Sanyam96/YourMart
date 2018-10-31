package com.nagarro.yourmart.controllers;

import com.nagarro.yourmart.dtos.ResponseModel;
import com.nagarro.yourmart.dtos.SellerRequest;
import com.nagarro.yourmart.dtos.SellerResponse;
import com.nagarro.yourmart.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sanyam Goel created on 30/10/18
 */
@RequestMapping(value = "/api/v1/")
@RestController
public class SellerController extends RestResponseHandler {

    @Autowired
    SellerService sellerService;

    @RequestMapping(method = RequestMethod.GET, value = "/sellers", produces = "application/json")
    public ResponseEntity<ResponseModel<List<SellerResponse>>> getAllSellers() {
        List<SellerResponse> sellersList = sellerService.getAllSellers();
        return super.responseStandardizer(sellersList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/seller/{id}", produces = "application/json")
    public ResponseEntity<ResponseModel<SellerResponse>> getSellerById(
            @PathVariable("id") long id
    ) {
        SellerResponse seller = sellerService.getSellerById(id);
        return super.responseStandardizer(seller);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/seller")
    public ResponseEntity<ResponseModel<String>> addSeller(
            @RequestBody SellerRequest sellerRequest
    ) {
        String sellerResponse = sellerService.createSeller(sellerRequest);
        return super.responseStandardizer(sellerResponse);
    }
}
