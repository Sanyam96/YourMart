package com.nagarro.yourmart.service;

import com.nagarro.yourmart.domains.Products;
import com.nagarro.yourmart.domains.Seller;
import com.nagarro.yourmart.dtos.ProductResponse;
import com.nagarro.yourmart.dtos.SellerResponse;
import com.nagarro.yourmart.exceptions.YourMartResourceNotFoundException;
import com.nagarro.yourmart.repository.YourMartRepository;
import com.nagarro.yourmart.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sanyam Goel created on 29/10/18
 */
@Service
public class YourMartService {

    @Autowired
    YourMartRepository yourMartRepository;

    public List<ProductResponse> getAllProducts() {
        List<Products> productsList = yourMartRepository.getList(Products.class);
        List<ProductResponse> productResponseList = Utility.convertModelList(productsList, ProductResponse.class);

        if (productsList == null) {
            throw new YourMartResourceNotFoundException("product list not found!");
        }

        return productResponseList;
    }

    public List<SellerResponse> getAllSellers() {
        List<Seller> sellerList = yourMartRepository.getList(Seller.class);
        List<SellerResponse> sellerResponseList = Utility.convertModelList(sellerList, SellerResponse.class);

        return sellerResponseList;
    }

}
