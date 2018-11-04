package com.nagarro.yourmart.service;

import com.nagarro.yourmart.domains.Categories;
import com.nagarro.yourmart.domains.Products;
import com.nagarro.yourmart.dtos.CategoryRequest;
import com.nagarro.yourmart.dtos.CategoryResponse;
import com.nagarro.yourmart.exceptions.YourMartResourceNotFoundException;
import com.nagarro.yourmart.repository.CategoryRepository;
import com.nagarro.yourmart.repository.ProductRepository;
import com.nagarro.yourmart.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.rmi.CORBA.Util;
import java.util.List;

/**
 * @author Sanyam Goel created on 31/10/18
 */
@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Transactional
    public List<CategoryResponse> getAllCategories(Long offset, Long limit) {
//        List<Categories> categories = categoryRepository.getList(Categories.class);
        List<Categories> categories = categoryRepository.getCategoriesPaginatedResult(offset, limit);
        List<CategoryResponse> categoryResponseList = Utility.convertModelList(categories, CategoryResponse.class);

        for (int i = 0; i < categoryResponseList.size(); i++) {
            categoryResponseList.get((int) i).setProductCount(getCountOfProductsPerCategory(categoryResponseList.get((int) i).getId()));
        }

        if(categoryResponseList == null || categories.isEmpty()) {
            throw new YourMartResourceNotFoundException("Categories list not found!");
        }
        return categoryResponseList;
    }

    @Transactional
    public CategoryResponse getCategoryByUniqueId(long id) {
        Categories category = categoryRepository.getById(id, Categories.class);
        CategoryResponse categoryResponse = Utility.convertModel(category, CategoryResponse.class);

        categoryResponse.setProductCount(getCountOfProductsPerCategory(categoryResponse.getId()));

        if(categoryResponse == null || category == null) {
            throw new YourMartResourceNotFoundException("Category not found with the given id: " + id);
        }
        return categoryResponse;
    }

    @Transactional
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        // db call
        Categories category = new Categories();
        category.setName(categoryRequest.getName());
        categoryRepository.create(category);
        CategoryResponse categoryResponse = Utility.convertModel(category, CategoryResponse.class);
        return categoryResponse;
    }

    @Transactional
    public String updateCategory(CategoryRequest categoryRequest, long id) {
        Categories category = categoryRepository.getById(id, Categories.class);

        if(category == null) {
            throw new YourMartResourceNotFoundException("Category not found with the given id: " + id);
        }
        // db call
        category.setName(categoryRequest.getName());
        categoryRepository.update(category);
        return "updated";
    }

    @Transactional
    public String updateCategoryByName(String categoryName, long id) {
        Categories category = categoryRepository.getById(id, Categories.class);

        if(category == null) {
            throw new YourMartResourceNotFoundException("Category not found with the given id: " + id);
        }
        // db call
        category.setName(categoryName);
        // todo add everywhere about update time
        System.out.println(System.currentTimeMillis());
        category.setUpdatedAt(System.currentTimeMillis());
        categoryRepository.update(category);
        return "updated";
    }

    @Transactional
    public String deleteCategory(long id) {
        Categories category = categoryRepository.getById(id, Categories.class);

        if(category == null) {
            throw new YourMartResourceNotFoundException("Category not found with the given id: " + id);
        }
        // db call
        categoryRepository.delete(category);
        return "deleted";
    }

    @Transactional
    public Categories getCategoryById(long id) {
        Categories category = categoryRepository.getById(id, Categories.class);

        if(category == null) {
            throw new YourMartResourceNotFoundException("Category not found with the given id: " + id);
        }
        return category;
    }

    @Transactional
    public long getCountOfProductsPerCategory(long categoryId) {
        List<Products> productsList = productRepository.getCountOfProductByCategory(categoryId);
        return productsList.size();
    }


}
