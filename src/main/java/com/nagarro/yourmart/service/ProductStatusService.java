package com.nagarro.yourmart.service;

import com.nagarro.yourmart.domains.ProductStatus;
import com.nagarro.yourmart.repository.ProductStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sanyam Goel created on 31/10/18
 */
@Service
public class ProductStatusService {

    @Autowired
    ProductStatusRepository productStatusRepository;

    @Transactional
    public ProductStatus getProductStatusById(long id) {
        ProductStatus productStatus = productStatusRepository.getById(id, ProductStatus.class);
        return productStatus;
    }
}
