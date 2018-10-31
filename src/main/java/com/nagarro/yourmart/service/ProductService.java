package com.nagarro.yourmart.service;

import com.nagarro.yourmart.domains.Products;
import com.nagarro.yourmart.dtos.ProductRequest;
import com.nagarro.yourmart.dtos.ProductResponse;
import com.nagarro.yourmart.exceptions.YourMartResourceNotFoundException;
import com.nagarro.yourmart.repository.ProductRepository;
import com.nagarro.yourmart.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Sanyam Goel created on 30/10/18
 */
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductStatusService productStatusService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SellerService sellerService;

    @Transactional
    public List<ProductResponse> getAllProducts() {
        List<Products> productsList = productRepository.getList(Products.class);
        List<ProductResponse> productResponseList = Utility.convertModelList(productsList, ProductResponse.class);
        System.out.println("hello");

        if(productResponseList == null || productsList.isEmpty()) {
            throw new YourMartResourceNotFoundException("product list not found!");
        }
        return productResponseList;
    }

    @Transactional
    public String createProduct(ProductRequest productRequest) {

        // db call
        Products product = new Products();

        product.setProductCode(productRequest.getProductCode());
        product.setProductName(productRequest.getProductName());
        product.setShortDescription(productRequest.getShortDescription());
        product.setLongDescription(productRequest.getLongDescription());
        product.setDimensions(productRequest.getDimensions());
//        product.setCategoryId(productRequest.getCategoryId()); // todo arraylist of categories Id or objects
        product.setCategories(categoryService.getCategoryById(productRequest.getCategoryId()));
        product.setMrp(productRequest.getMrp());
        product.setSsp(productRequest.getSsp());
        product.setYmp(productRequest.getYmp());
        product.setSellerId(productRequest.getSellerId()); // todo store object
        product.setSeller(sellerService.getSellerId(productRequest.getSellerId()));
        System.out.println("halfDone");


        // product status id
        // NEW with id 1
        // seller.setSellerStatus(sellerStatusService.getSellerStatusById(1));

        product.setProductStatus(productStatusService.getProductStatusById(1));
        System.out.println("done");
        productRepository.create(product);


        System.out.println("fulldone");

        return "created";
    }

}
