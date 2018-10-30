package com.nagarro.yourmart.controllers;

import com.nagarro.yourmart.dtos.ProductsDTO;
import com.nagarro.yourmart.dtos.ResponseModel;
import com.nagarro.yourmart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Sanyam Goel created on 30/10/18
 */
@RequestMapping(value = "/api/v1/")
@RestController
public class ProductController extends RestResponseHandler {

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET, value = "/products", produces = "application/json")
    public ResponseEntity<ResponseModel<List<ProductsDTO>>> getAllProducts() {
        List<ProductsDTO> productsList = productService.getAllProducts();
        return super.responseStandardizer(productsList);
    }

}
