package com.nagarro.yourmart.service;

import com.nagarro.yourmart.domains.Categories;
import com.nagarro.yourmart.dtos.CategoryRequest;
import com.nagarro.yourmart.dtos.CategoryResponse;
import com.nagarro.yourmart.exceptions.YourMartResourceNotFoundException;
import com.nagarro.yourmart.repository.CategoryRepository;
import com.nagarro.yourmart.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Sanyam Goel created on 31/10/18
 */
@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    public List<CategoryResponse> getAllCategories() {
        List<Categories> categories = categoryRepository.getList(Categories.class);
        List<CategoryResponse> categoryResponseList = Utility.convertModelList(categories, CategoryResponse.class);

        if(categoryResponseList == null || categories.isEmpty()) {
            throw new YourMartResourceNotFoundException("Categories list not found!");
        }
        return categoryResponseList;
    }

    @Transactional
    public CategoryResponse getCategoryByUniqueId(long id) {
        Categories category = categoryRepository.getById(id, Categories.class);
        CategoryResponse categoryResponse = Utility.convertModel(category, CategoryResponse.class);

        if(categoryResponse == null || category == null) {
            throw new YourMartResourceNotFoundException("Category not found with the given id: " + id);
        }
        return categoryResponse;
    }

    @Transactional
    public String createCategory(CategoryRequest categoryRequest) {
        // db call
        Categories category = new Categories();
        category.setName(categoryRequest.getName());
        categoryRepository.create(category);
        return "created";
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


}
