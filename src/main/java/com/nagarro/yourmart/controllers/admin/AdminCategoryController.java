package com.nagarro.yourmart.controllers.admin;

import com.nagarro.yourmart.dtos.CategoryResponse;
import com.nagarro.yourmart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Sanyam Goel created on 4/11/18
 */
@Controller
public class AdminCategoryController {

    @Autowired
    CategoryService categoryService;

    //    CATEGORIES
    @RequestMapping(value = "/admin/categories", method = RequestMethod.GET)
    public String getAllCategories(
            Model model,
            HttpServletResponse response,
            HttpServletRequest request,
            @RequestParam(required = false, name = "limit", defaultValue = "10") Long limit,
            @RequestParam(required = false, name = "offset", defaultValue = "0") Long offset
    ) {
        HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute("admin") != null) {
            List<CategoryResponse> categoryResponses = categoryService.getAllCategories(offset, limit);
            model.addAttribute("cat", categoryResponses);
            return "categories";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/categories/delete", method = RequestMethod.GET)
    public String deleteCategory(
            Model model,
            HttpServletResponse response,
            HttpServletRequest request,
            @RequestParam(value = "categoryId", required = false) Long categoryId
    ) {
        HttpSession session = request.getSession(false);
        System.out.println(categoryId);
        CategoryResponse s = categoryService.deleteCategory(categoryId);
        return "redirect:/admin/categories";
    }

    @RequestMapping(value = "/admin/categories/update", method = RequestMethod.GET)
    public String updateCategory(
            Model model,
            HttpServletResponse response,
            HttpServletRequest request,
            @RequestParam(value = "categoryId", required = false) Long categoryId,
            @RequestParam(value = "categoryName", required = false) String categoryName
    ) {
        System.out.println(categoryId);
        System.out.println(categoryName);
        HttpSession session = request.getSession(false);
        CategoryResponse categoryResponse = categoryService.updateCategoryByName(categoryName, categoryId);
        return "redirect:/admin/categories";
    }
}
