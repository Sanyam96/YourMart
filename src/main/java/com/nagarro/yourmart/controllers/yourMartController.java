package com.nagarro.yourmart.controllers;

import com.nagarro.yourmart.domains.Admin;
import com.nagarro.yourmart.dtos.*;
import com.nagarro.yourmart.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Sanyam Goel created on 29/10/18
 */
//@RequestMapping(value = "/api/v1/")
//@RestController
@Controller
public class yourMartController extends RestResponseHandler {

    @Autowired
    YourMartService yourMartService;

    @Autowired
    AdminService adminService;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SellerService sellerService;

    @RequestMapping(method = RequestMethod.GET, value = "/hello", produces = "application/json")
    public ResponseEntity<ResponseModel<String>> getAllData() {
        return super.responseStandardizer("Hello");
    }









    // LOGIN
    @RequestMapping("/admin/login")
    public String loginPage(ModelMap modelMap) {
        return "login";
    }

    @RequestMapping(value="/admin/login", method = RequestMethod.POST)
    public String getAdminLoggedIn(
            ModelMap model,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        AdminResponse admin = adminService.authenticate(username,password);
        request.getSession().setAttribute("admin", admin);
        return "redirect:/admin/home";
    }

    @RequestMapping(value="/admin/home",method = RequestMethod.GET)
    public String homePage(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        HttpSession session = request.getSession(false);
        if(session!=null && session.getAttribute("admin")!=null) {
            return "home";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value="/admin/logout",method = RequestMethod.POST)
    public String adminLogout(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        HttpSession session = request.getSession(false);
        if(session!=null && session.getAttribute("admin")!=null) {
            session.setAttribute("admin", null);
        }
        return "redirect:/admin/login";
    }











//  PRODUCTS
    @RequestMapping(value = "/admin/products", method = RequestMethod.GET)
    public String getAllProducts(
            Model model,
            HttpServletResponse response,
            HttpServletRequest request,
            @RequestParam(value="sortBy",required = false) String sortBy,
            @RequestParam(value="sellerId",required = false) Long sellerId,
            @RequestParam(required = false, name = "productCode") String productCode,
            @RequestParam(required = false, name = "productName") String productName,
            @RequestParam(required = false, name = "productId") Long productId,
//            @RequestParam(required = false, name = "sort") String sortParamater,
            @RequestParam(required = false, name = "categoryId") Long categoryId,
            @RequestParam(required = false, name = "productStatusId") Long productStatusId
    ) {
        HttpSession session = request.getSession(false);
        if(sortBy!=null) {
            String mrpChecked = sortBy.equals("mrp") ? "checked" : " ";
            model.addAttribute("mrpChecked", mrpChecked);
            String sspChecked = sortBy.equals("ssp") ? "checked" : " ";
            model.addAttribute("sspChecked", sspChecked);
            String ympChecked = sortBy.equals("ymp") ? "checked" : " ";
            model.addAttribute("ympChecked", ympChecked);
            String createdAtChecked = sortBy.equals("createdAt") ? "checked" : " ";
            model.addAttribute("createdAtChecked", createdAtChecked);
            String updatedAtChecked = sortBy.equals("updatedAt") ? "checked" : " ";
            model.addAttribute("updatedAtChecked", updatedAtChecked);
        }

        if(session != null) {
            List<ProductResponse> productResponse = productService.getAllProductsBySellerId(sellerId, productCode, productName, productId, sortBy, categoryId, productStatusId);
            model.addAttribute("ab", productResponse);
            return "productList";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/prod", method = RequestMethod.GET)
    public String getProduct(
            Model model,
            HttpServletResponse response,
            HttpServletRequest request,
            @RequestParam(value="sellerId",required = false) Long sellerId,
            @RequestParam(required = false, name = "productCode") String productCode,
            @RequestParam(required = false, name = "productName") String productName,
            @RequestParam(required = false, name = "productId") Long productId,
//            @RequestParam(required = false, name = "sort") String sortParamater,
            @RequestParam(required = false, name = "categoryId") Long categoryId,
            @RequestParam(required = false, name = "mrp") Double mrp,
            @RequestParam(required = false, name = "ssp") Double ssp,
            @RequestParam(required = false, name = "ymp") Double ymp,
            @RequestParam(required = false, name = "shortDescription") String shortDescription,
            @RequestParam(required = false, name = "longDescription") String longDescription,
            @RequestParam(required = false, name = "dimensions") String dimensions,
            @RequestParam(required = false, name = "flag" ,defaultValue = "0") Long flag
    ) {
        HttpSession session = request.getSession(false);

        ProductResponse productResponse = productService.getProductById(productId);
        model.addAttribute("ab", productResponse);

        if(productResponse != null && flag == 1) {
            return "product";
        }

        ProductRequest productRequest = new ProductRequest();
        productRequest.setProductCode(productCode);
        productRequest.setProductName(productName);
        productRequest.setShortDescription(shortDescription);
        productRequest.setLongDescription(longDescription);
        productRequest.setDimensions(dimensions);
        productRequest.setCategoryId(categoryId);
        productRequest.setMrp(mrp);
        productRequest.setSsp(ssp);
        productRequest.setYmp(ymp);
        productRequest.setSellerId(sellerId);
        String s = productService.updateProduct(productRequest, productId);

//        List<ProductResponse> responses = productService.getAllProductsBySellerId("0", null, null, 0, null, 0, 0);
        return "redirect:/admin/products";

//        if(session != null) {
//            String productResponse = productService.updateProduct(productRequest,productId);
//            model.addAttribute("ab", productResponse);
//            return "productList";
//        }
//        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/products/update-status", method = RequestMethod.GET)
    public String approveProducts(
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        String[] ids = request.getParameterValues("cbox");
        if(ids!=null) {
            for(String value : ids) {
                System.out.println(value);
                // 2=>APPROVED
                long id = Long.parseLong(String.valueOf(value));
                productService.updateProductStatus(id);
            }
        }
        return "redirect:/admin/products";
    }














//    CATEGORIES
    @RequestMapping(value = "/admin/categories", method = RequestMethod.GET)
    public String getAllCategories(
            Model model,
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession(false);
        List<CategoryResponse> categoryResponses = categoryService.getAllCategories();
        model.addAttribute("cat", categoryResponses);
        return "categories";
//        if(session != null) {
//            List<CategoryResponse> categoryResponses = categoryService.getAllCategories();
//            model.addAttribute("cat", categoryResponses);
//            return "category";
//        }
//        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/categories/delete", method = RequestMethod.GET)
    public String deleteCategory(
            Model model,
            HttpServletResponse response,
            HttpServletRequest request,
            @RequestParam(value="categoryId",required = false) Long categoryId
    ) {
        HttpSession session = request.getSession(false);
        System.out.println(categoryId);
        String s = categoryService.deleteCategory(categoryId);
        return "redirect:/admin/categories";
    }

    @RequestMapping(value = "/admin/categories/update", method = RequestMethod.GET)
    public String updateCategory (
            Model model,
            HttpServletResponse response,
            HttpServletRequest request,
            @RequestParam(value="categoryId",required = false) Long categoryId,
            @RequestParam(value="categoryName",required = false) String categoryName
        ) {
        System.out.println(categoryId);
        System.out.println(categoryName);
        HttpSession session = request.getSession(false);
        String s = categoryService.updateCategoryByName(categoryName, categoryId);
        return "redirect:/admin/categories";
    }











//    SELLERS
    @RequestMapping(value = "/admin/sellers", method = RequestMethod.GET)
    public String viewSellers(
            Model model,
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession(false);

        if(session != null) {
            List<SellerResponse> sellerResponses = sellerService.getAllSellers();
            model.addAttribute("ab", sellerResponses);
            return "sellerList";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/sel", method = RequestMethod.GET)
    public String viewSeller(
            Model model,
            HttpServletResponse response,
            HttpServletRequest request,
            @RequestParam(value="sellerId",required = false) Long sellerId,
            @RequestParam(required = false, name = "flag" ,defaultValue = "0") Long flag,
            @RequestParam(required = false, name = "companyName") String companyName,
            @RequestParam(required = false, name = "ownerName") String ownerName,
            @RequestParam(required = false, name = "address") String address,
            @RequestParam(required = false, name = "emailAddress") String emailAddress,
            @RequestParam(required = false, name = "telephoneNumber") Long telephoneNumber,
            @RequestParam(required = false, name = "gstNumber") String gstNumber,
            @RequestParam(required = false, name = "password") String password
    ) {
        HttpSession session = request.getSession(false);

        SellerResponse sellerResponse = sellerService.getSellerById(sellerId);
        model.addAttribute("ab", sellerResponse);

        if(sellerResponse != null && flag == 1) {
            return "seller";
        }

        SellerRequest sellerRequest = new SellerRequest();
        sellerRequest.setCompanyName(companyName);
        sellerRequest.setOwnerName(ownerName);
        sellerRequest.setAddress(address);
        sellerRequest.setEmailAddress(emailAddress);
        sellerRequest.setTelephoneNumber(telephoneNumber);
        sellerRequest.setGstNumber(gstNumber);
        SellerResponse s = sellerService.updateSeller(sellerRequest, sellerId);
        return "redirect:/admin/sellers";



        /*
        ProductRequest productRequest = new ProductRequest();
        productRequest.setProductCode(productCode);
        productRequest.setProductName(productName);
        productRequest.setShortDescription(shortDescription);
        productRequest.setLongDescription(longDescription);
        productRequest.setDimensions(dimensions);
        productRequest.setCategoryId(categoryId);
        productRequest.setMrp(mrp);
        productRequest.setSsp(ssp);
        productRequest.setYmp(ymp);
        productRequest.setSellerId(sellerId);
        String s = productService.updateProduct(productRequest, productId);

//        List<ProductResponse> responses = productService.getAllProductsBySellerId("0", null, null, 0, null, 0, 0);
        return "redirect:/admin/products";


         */



//        if(session != null) {
//            List<SellerResponse> sellerResponses = sellerService.getAllSellers();
//            model.addAttribute("ab", sellerResponses);
//            return "sellerList";
//        }
    }

    @RequestMapping(value = "/admin/seller/update-seller", method = RequestMethod.GET)
    public String updateSellerStatus(
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        String[] ids = request.getParameterValues("cbox");
        if(ids!=null) {
            for(String value : ids) {
                System.out.println(value);
                // 4=>APPROVED
                long id = Long.parseLong(String.valueOf(value));
                sellerService.updateSellerStatus(id);
            }
        }
        return "redirect:/admin/sellers";
    }



}
