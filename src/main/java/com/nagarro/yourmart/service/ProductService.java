package com.nagarro.yourmart.service;

import com.nagarro.yourmart.domains.Products;
import com.nagarro.yourmart.dtos.ProductsDTO;
import com.nagarro.yourmart.exceptions.YourMartResourceNotFoundException;
import com.nagarro.yourmart.repository.ProductRepository;
import com.nagarro.yourmart.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sanyam Goel created on 30/10/18
 */
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public List<ProductsDTO> getAllProducts() {
        List<Products> productsList = productRepository.getList(Products.class);
        List<ProductsDTO> productsDTOList = Utility.convertModelList(productsList, ProductsDTO.class);
        System.out.println("hello");

        if(productsDTOList == null || productsList.isEmpty()) {
            throw new YourMartResourceNotFoundException("product list not found!");
        }
        return productsDTOList;
    }

}
