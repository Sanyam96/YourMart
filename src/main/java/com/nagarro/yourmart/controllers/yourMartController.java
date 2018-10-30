package com.nagarro.yourmart.controllers;

import com.nagarro.yourmart.domains.Products;
import com.nagarro.yourmart.domains.Seller;
import com.nagarro.yourmart.dtos.ProductsDTO;
import com.nagarro.yourmart.dtos.ResponseModel;
import com.nagarro.yourmart.dtos.SellersDTO;
import com.nagarro.yourmart.service.YourMartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Sanyam Goel created on 29/10/18
 */
@RequestMapping(value = "/api/v1/")
@RestController
public class yourMartController extends RestResponseHandler {

    @Autowired
    YourMartService yourMartService;

    @RequestMapping(method = RequestMethod.GET, value = "/hello", produces = "application/json")
    public ResponseEntity<ResponseModel<String>> getAllData() {
        return super.responseStandardizer("Hello");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/products", produces = "application/json")
    public ResponseEntity<ResponseModel<List<ProductsDTO>>> getAllProducts() {
        List<ProductsDTO> productsList = yourMartService.getAllProducts();
        return super.responseStandardizer(productsList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sellers", produces = "application/json")
    public ResponseEntity<ResponseModel<List<SellersDTO>>> getAllSellers() {
        List<SellersDTO> sellersList = yourMartService.getAllSellers();
        return super.responseStandardizer(sellersList);
    }

}
