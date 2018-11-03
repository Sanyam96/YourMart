package com.nagarro.yourmart.service;

import com.nagarro.yourmart.domains.Products;
import com.nagarro.yourmart.dtos.ProductRequest;
import com.nagarro.yourmart.dtos.ProductResponse;
import com.nagarro.yourmart.enums.ProductStatusEnum;
import com.nagarro.yourmart.exceptions.YourMartResourceNotFoundException;
import com.nagarro.yourmart.repository.ProductRepository;
import com.nagarro.yourmart.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    public List<ProductResponse> getAllProducts(long sId, String productCode, String productName, long productId, String sortParamater, long cId, long productStatusId) {
        List<Products> productsList = productRepository.getList(Products.class);
        List<ProductResponse> productResponseList = Utility.convertModelList(productsList, ProductResponse.class);
//        System.out.println("hello");

        for (long i = 0; i < productResponseList.size(); i++) {
            if(productResponseList.get((int) i).getProductStatusId() == 1) {
                productResponseList.get((int) i).setProductStatus(ProductStatusEnum.NEW);
            } else if(productResponseList.get((int) i).getProductStatusId() == 2) {
                productResponseList.get((int) i).setProductStatus(ProductStatusEnum.APPROVED);
            } else if(productResponseList.get((int) i).getProductStatusId() == 3){
                productResponseList.get((int) i).setProductStatus(ProductStatusEnum.REJECTED);
            } else if(productResponseList.get((int) i).getProductStatusId() == 4){
                productResponseList.get((int) i).setProductStatus(ProductStatusEnum.REVIEW);
            }
            long sellerId = productResponseList.get((int) i).getSellerId();
            productResponseList.get((int) i).setSellerCompanyName(sellerService.getSellerById(sellerId).getCompanyName());

            long categoryId = productResponseList.get((int) i).getCategoryId();
            productResponseList.get((int) i).setCategoryName(categoryService.getCategoryById(categoryId).getName());

            Date createdAtInHumanDate = new Date(productResponseList.get((int) i).getCreatedAt());
            Date updatedAtInHumanDate = new Date(productResponseList.get((int) i).getUpdatedAt());
            productResponseList.get((int) i).setCreatedAtInHumanDate(createdAtInHumanDate);
            productResponseList.get((int) i).setUpdatedAtInHumanDate(updatedAtInHumanDate);


//            long test_timestamp = productResponseList.get((int) i).getCreatedAt();
//            LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(test_timestamp), TimeZone.getDefault().toZoneId());
//            productResponseList.get((int) i).setCreatedAt(localDateTime);
        }

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
        product.setProductStatus(productStatusService.getProductStatusById(1));
        System.out.println("done");
        productRepository.create(product);

        System.out.println("fulldone");

        // todo
        return "created";
    }

    @Transactional
    public String updateProduct(ProductRequest productRequest, long id) {

        // db call
        Products product = productRepository.getById(id, Products.class);

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
        // REVIEW with id 4
        product.setProductStatus(productStatusService.getProductStatusById(4));

        productRepository.update(product);

        System.out.println("fulldone");

        // todo
        return "updated";
    }

    @Transactional
    public ProductResponse getProductById(long id) {
        Products product = productRepository.getById(id, Products.class);
        ProductResponse productResponse = Utility.convertModel(product, ProductResponse.class);

        if(productResponse.getProductStatusId() == 1) {
            productResponse.setProductStatus(ProductStatusEnum.NEW);
        } else if(productResponse.getProductStatusId() == 2) {
            productResponse.setProductStatus(ProductStatusEnum.APPROVED);
        } else if(productResponse.getProductStatusId() == 3){
            productResponse.setProductStatus(ProductStatusEnum.REJECTED);
        } else if(productResponse.getProductStatusId() == 4){
            productResponse.setProductStatus(ProductStatusEnum.REVIEW);
        }

        if(productResponse == null || product == null) {
            throw new YourMartResourceNotFoundException("Product not found with the given id: " + id);
        }

        return productResponse;
    }

    @Transactional
    public List<ProductResponse> getAllProductsBySellerId(Long sellerId, String productCode, String productName, Long productId, String sortParamater, Long categoryId, Long productStatusId, Long offset, Long limit) {
        List<Products> products = productRepository.getProductsListBySellerId(sellerId, productCode, productName, productId, sortParamater, categoryId, productStatusId, offset, limit);
        List<ProductResponse> productResponseList = Utility.convertModelList(products, ProductResponse.class);

        for (long i = 0; i < productResponseList.size(); i++) {
            if(productResponseList.get((int) i).getProductStatusId() == 1) {
                productResponseList.get((int) i).setProductStatus(ProductStatusEnum.NEW);
            } else if(productResponseList.get((int) i).getProductStatusId() == 2) {
                productResponseList.get((int) i).setProductStatus(ProductStatusEnum.APPROVED);
            } else if(productResponseList.get((int) i).getProductStatusId() == 3){
                productResponseList.get((int) i).setProductStatus(ProductStatusEnum.REJECTED);
            } else if(productResponseList.get((int) i).getProductStatusId() == 4){
                productResponseList.get((int) i).setProductStatus(ProductStatusEnum.REVIEW);
            }

            // todo
            long sellerIdFromResponse = productResponseList.get((int) i).getSellerId();
            productResponseList.get((int) i).setSellerCompanyName(sellerService.getSellerById(sellerIdFromResponse).getCompanyName());

            long categoryIdFromResponse = productResponseList.get((int) i).getCategoryId();
            productResponseList.get((int) i).setCategoryName(categoryService.getCategoryById(categoryIdFromResponse).getName());

            Date createdAtInHumanDate = new Date(productResponseList.get((int) i).getCreatedAt());
            Date updatedAtInHumanDate = new Date(productResponseList.get((int) i).getUpdatedAt());
            productResponseList.get((int) i).setCreatedAtInHumanDate(createdAtInHumanDate);
            productResponseList.get((int) i).setUpdatedAtInHumanDate(updatedAtInHumanDate);


//            long test_timestamp = productResponseList.get((int) i).getCreatedAt();
//            LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(test_timestamp), TimeZone.getDefault().toZoneId());
//            productResponseList.get((int) i).setCreatedAt(localDateTime);
        }

        if(productResponseList == null || products.isEmpty()) {
            throw new YourMartResourceNotFoundException("Product List not found with the given id: " + sellerId);
        }
        System.out.println("hello");
        return productResponseList;
    }

    @Transactional
    public ProductResponse getProductBySellerIdProductId(long sellerId, long productId) {
        Products product = productRepository.getProductBySellerIdProductId(sellerId, productId);
        ProductResponse productResponse = Utility.convertModel(product, ProductResponse.class);

        if(productResponse == null || product == null) {
            throw new YourMartResourceNotFoundException("Product not found with the given Seller id: " + sellerId + " or Product id: " + productId);
        }

        return productResponse;
    }

    @Transactional
    public String updateProductStatus(long id) {

        // db call
        Products product = productRepository.getById(id, Products.class);


        // Approva with id 2
        product.setProductStatus(productStatusService.getProductStatusById(2));

        productRepository.update(product);

        System.out.println("fulldone");

        // todo
        return "updated";
    }

}
