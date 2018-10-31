package com.nagarro.yourmart.service;

import com.nagarro.yourmart.domains.Categories;
import com.nagarro.yourmart.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sanyam Goel created on 31/10/18
 */
@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    /*
    @Transactional
    public SellerStatus getSellerStatusById(long id) {
        SellerStatus sellerStatus = sellerStatusRepository.getById(id, SellerStatus.class);
//        SellerResponse sellerDTO = Utility.convertModel(seller, SellerResponse.class);

//        if(sellerDTO == null || seller == null) {
//            throw new YourMartResourceNotFoundException("Seller not found with the given id: " + id);
//        }
        return sellerStatus;
    }
     */

    public Categories getCategoryById(long id) {
        Categories category = categoryRepository.getById(id, Categories.class);
        return category;
    }
}
