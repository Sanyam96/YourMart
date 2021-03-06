package com.nagarro.yourmart.controllers;

import com.nagarro.yourmart.dtos.CategoryRequest;
import com.nagarro.yourmart.dtos.CategoryResponse;
import com.nagarro.yourmart.dtos.ResponseModel;
import com.nagarro.yourmart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sanyam Goel created on 31/10/18
 */
@RequestMapping(value = "/api/v1/")
@RestController
public class CategoryController extends RestResponseHandler {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET, value = "/categories", produces = "application/json")
    public ResponseEntity<ResponseModel<List<CategoryResponse>>> getAllCategories(
            @RequestParam(required = false, name = "limit", defaultValue = "2") Long limit,
            @RequestParam(required = false, name = "offset", defaultValue = "0") Long offset
    ) {
        List<CategoryResponse> categories = categoryService.getAllCategories(offset, limit);
        return super.responseStandardizer(categories);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category/{id}", produces = "application/json")
    public ResponseEntity<ResponseModel<CategoryResponse>> getCategoryById(
            @PathVariable("id") long id
    ) {
        CategoryResponse category = categoryService.getCategoryByUniqueId(id);
        return super.responseStandardizer(category);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/category")
    public ResponseEntity<ResponseModel<CategoryResponse>> addCategory(
            @RequestBody CategoryRequest categoryRequest
    ) {
        CategoryResponse categoryResponse = categoryService.createCategory(categoryRequest);
        return super.responseStandardizer(categoryResponse);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/category/{id}")
    public ResponseEntity<ResponseModel<CategoryResponse>> updateCategory(
            @RequestBody CategoryRequest categoryRequest,
            @PathVariable("id") long id
    ) {
        CategoryResponse categoryResponse = categoryService.updateCategory(categoryRequest, id);
        return super.responseStandardizer(categoryResponse);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/category/{id}")
    public ResponseEntity<ResponseModel<CategoryResponse>> deleteCategory(
            @PathVariable("id") long id
    ) {
        CategoryResponse categoryResponse = categoryService.deleteCategory(id);
        return super.responseStandardizer(categoryResponse);
    }
}
