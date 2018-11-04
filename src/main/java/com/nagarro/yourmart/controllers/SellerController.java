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
    public ResponseEntity<ResponseModel<List<SellerResponse>>> getAllSellers(
            @RequestParam(required = false, name = "limit", defaultValue = "2") Long limit,
            @RequestParam(required = false, name = "offset", defaultValue = "0") Long offset
    ) {
        List<SellerResponse> sellersList = sellerService.getAllSellers(offset, limit);
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

    @RequestMapping(method = RequestMethod.PUT, value = "/seller/{sellerId}")
    public ResponseEntity<ResponseModel<SellerResponse>> updateSeller(
            @PathVariable("sellerId") Long sellerId,
            @RequestBody SellerRequest sellerRequest
    ) {
        SellerResponse sellerResponse = sellerService.updateSeller(sellerRequest, sellerId);
        return super.responseStandardizer(sellerResponse);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/seller/login", produces = "application/json")
    public ResponseEntity<ResponseModel<SellerResponse>> loginSeller(
            @RequestBody SellerLoginRequest sellerlogin
    ) {
        SellerResponse s = sellerService.checkUser(sellerlogin);
        return super.responseStandardizer(s);

    }

    /**
     * get all products and search products
     * @param sellerId
     * @param productCode
     * @param productName
     * @param productId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/seller/{sellerId}/products", produces = "application/json")
    public ResponseEntity<ResponseModel<List<ProductResponse>>> getProductsBySellerId (
            @PathVariable("sellerId") Long sellerId,
            @RequestParam(required = false, name = "productCode") String productCode,
            @RequestParam(required = false, name = "productName") String productName,
            @RequestParam(required = false, name = "productId") Long productId,
            @RequestParam(required = false, name = "sort") String sortParamater,
            @RequestParam(required = false, name = "categoryId") Long categoryId,
            @RequestParam(required = false, name = "productStatusId") Long productStatusId,
            @RequestParam(required = false, name = "limit", defaultValue = "5") Long limit,
            @RequestParam(required = false, name = "offset", defaultValue = "0") Long offset
    ) {
        List<ProductResponse> productsList = productService.getAllProductsBySellerId(sellerId, productCode, productName, productId, sortParamater, categoryId, productStatusId, offset, limit);
        return super.responseStandardizer(productsList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/seller/{sellerId}/product/{productId}", produces = "application/json")
    public ResponseEntity<ResponseModel<ProductResponse>> getProductBySellerIdProductId (
            @PathVariable("sellerId") long sellerId,
            @PathVariable("productId") long productId
    ) {
        ProductResponse product = productService.getProductBySellerIdProductId(sellerId, productId);
        return super.responseStandardizer(product);
    }

}
