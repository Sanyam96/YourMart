package com.nagarro.yourmart.controllers;

import com.nagarro.yourmart.dtos.ProductRequest;
import com.nagarro.yourmart.dtos.ProductResponse;
import com.nagarro.yourmart.dtos.ResponseModel;
import com.nagarro.yourmart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ResponseModel<List<ProductResponse>>> getAllProducts() {
        List<ProductResponse> productsList = productService.getAllProducts();
        return super.responseStandardizer(productsList);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/product")
    public ResponseEntity<ResponseModel<String>> createProduct(
            @RequestBody ProductRequest productRequest
    ) {
        String productResponse = productService.createProduct(productRequest);
        return super.responseStandardizer(productResponse);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/product/{id}", produces = "application/json")
    public ResponseEntity<ResponseModel<ProductResponse>> getProductById(
            @PathVariable("id") long id
    ) {
        return null;
    }

}
