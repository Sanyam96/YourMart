package com.nagarro.yourmart.service;

import com.nagarro.yourmart.domains.Products;
import com.nagarro.yourmart.dtos.ProductsDTO;
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

    public List<ProductsDTO> getAllProducts() {
        List<Products> productsList = yourMartRepository.getList(Products.class);
        List<ProductsDTO> productsDTOList = Utility.convertModelList(productsList, ProductsDTO.class);
        System.out.println("hello");

        if(productsList == null) {
            throw new YourMartResourceNotFoundException("product list not found!");
        }

        return productsDTOList;
    }

}
