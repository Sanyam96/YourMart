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
    public ResponseEntity<ResponseModel<List<ProductResponse>>> getAllProducts(
            @RequestParam(value="sortBy",required=false) String sortBy,
            @RequestParam(name="sellerId",required=false) Long sellerId,
            @RequestParam(required = false, name = "productCode") String productCode,
            @RequestParam(required = false, name = "productName") String productName,
            @RequestParam(required = false, name = "productId") Long productId,
//            @RequestParam(required = false, name = "sort") String sortParamater,
            @RequestParam(required = false, name = "categoryId") Long categoryId,
            @RequestParam(required = false, name = "productStatusId") Long productStatusId
    ) {
        List<ProductResponse> productsList = productService.getAllProductsBySellerId(sellerId, productCode, productName, productId, sortBy, categoryId, productStatusId);
        return super.responseStandardizer(productsList);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/product")
    public ResponseEntity<ResponseModel<String>> createProduct(
            @RequestBody ProductRequest productRequest
    ) {
        String productResponse = productService.createProduct(productRequest);
        return super.responseStandardizer(productResponse);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/product/{productId}")
    public ResponseEntity<ResponseModel<String>> updateProduct(
            @RequestBody ProductRequest productRequest,
            @PathVariable("productId") long productId
    ) {
        String productResponse = productService.updateProduct(productRequest, productId);
        return super.responseStandardizer(productResponse);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/product/{id}", produces = "application/json")
    public ResponseEntity<ResponseModel<ProductResponse>> getProductById(
            @PathVariable("id") long id
    ) {
        ProductResponse product = productService.getProductById(id);
        return super.responseStandardizer(product);
    }

}
