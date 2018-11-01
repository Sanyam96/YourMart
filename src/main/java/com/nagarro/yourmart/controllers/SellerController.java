package com.nagarro.yourmart.controllers;

import com.nagarro.yourmart.dtos.*;
import com.nagarro.yourmart.service.ProductService;
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

    @Autowired
    ProductService productService;

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
    public ResponseEntity<ResponseModel<SellerResponse>> addSeller(
            @RequestBody SellerRequest sellerRequest
    ) {
        SellerResponse sellerResponse = sellerService.createSeller(sellerRequest);
        return super.responseStandardizer(sellerResponse);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/seller/login", produces = "application/json")
    public ResponseEntity<ResponseModel<String>> loginSeller(
            @RequestBody SellerLoginRequest sellerlogin
    ) {
        String s = sellerService.checkUser(sellerlogin);
        return super.responseStandardizer(s);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/seller/{sellerId}/products", produces = "application/json")
    public ResponseEntity<ResponseModel<List<ProductResponse>>> getProductsBySellerId (
            @PathVariable("sellerId") long sellerId
    ) {
        List<ProductResponse> productsList = productService.getAllProductsBySellerId(sellerId);
        return super.responseStandardizer(productsList);
    }
}
