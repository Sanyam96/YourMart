package com.nagarro.yourmart.controllers;

import com.nagarro.yourmart.dtos.ResponseModel;
import com.nagarro.yourmart.dtos.SellersDTO;
import com.nagarro.yourmart.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<ResponseModel<List<SellersDTO>>> getAllSellers() {
        List<SellersDTO> sellersList = sellerService.getAllSellers();
        return super.responseStandardizer(sellersList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/seller/{id}", produces = "application/json")
    public ResponseEntity<ResponseModel<SellersDTO>> getSellerById(
            @PathVariable("id") long id
    ) {
        SellersDTO seller = sellerService.getSellerById(id);
        return super.responseStandardizer(seller);
    }
}
