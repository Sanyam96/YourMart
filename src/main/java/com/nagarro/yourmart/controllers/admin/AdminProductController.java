package com.nagarro.yourmart.controllers.admin;

import com.nagarro.yourmart.dtos.ProductRequest;
import com.nagarro.yourmart.dtos.ProductResponse;
import com.nagarro.yourmart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
public class AdminProductController {

    @Autowired
    ProductService productService;

    //  PRODUCTS
    @RequestMapping(value = "/admin/products", method = RequestMethod.GET)
    public String getAllProducts(
            Model model,
            HttpServletResponse response,
            HttpServletRequest request,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "sellerId", required = false) Long sellerId,
            @RequestParam(required = false, name = "productCode") String productCode,
            @RequestParam(required = false, name = "productName") String productName,
            @RequestParam(required = false, name = "productId") Long productId,
//            @RequestParam(required = false, name = "sort") String sortParamater,
            @RequestParam(required = false, name = "categoryId") Long categoryId,
            @RequestParam(required = false, name = "productStatusId") Long productStatusId,
            @RequestParam(required = false, name = "limit", defaultValue = "10") Long limit,
            @RequestParam(required = false, name = "offset", defaultValue = "0") Long offset
    ) {

        HttpSession session = request.getSession(false);
        if (sortBy != null) {
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

        if(session != null && session.getAttribute("admin") != null) {
        List<ProductResponse> productResponse = productService.getAllProductsBySellerId(sellerId, productCode, productName, productId, sortBy, categoryId, productStatusId, offset, limit);
        model.addAttribute("ab", productResponse);
        return "productList";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/product/{productId}", method = RequestMethod.GET)
    public String getProduct(
            Model model,
            HttpServletResponse response,
            HttpServletRequest request,
            @RequestParam(value = "sellerId", required = false) Long sellerId,
            @RequestParam(required = false, name = "productCode") String productCode,
            @RequestParam(required = false, name = "productName") String productName,
            @PathVariable("productId") Long productId,
//            @RequestParam(required = false, name = "sort") String sortParamater,
            @RequestParam(required = false, name = "categoryId") Long categoryId,
            @RequestParam(required = false, name = "mrp") Double mrp,
            @RequestParam(required = false, name = "ssp") Double ssp,
            @RequestParam(required = false, name = "ymp") Double ymp,
            @RequestParam(required = false, name = "shortDescription") String shortDescription,
            @RequestParam(required = false, name = "longDescription") String longDescription,
            @RequestParam(required = false, name = "dimensions") String dimensions,
            @RequestParam(required = false, name = "flag", defaultValue = "0") Long flag
    ) {
        HttpSession session = request.getSession(false);

        ProductResponse productResponse = productService.getProductById(productId);
        model.addAttribute("ab", productResponse);

        if (productResponse != null) {
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
        ProductResponse productResponse1 = productService.updateProduct(productRequest, productId);

        return "redirect:/admin/products";

    }

    @RequestMapping(value = "/admin/prod/", method = RequestMethod.GET)
    public String updateProduct(
            Model model,
            HttpServletResponse response,
            HttpServletRequest request,
            @RequestParam(value = "sellerId", required = false) Long sellerId,
            @RequestParam(required = false, name = "productCode") String productCode,
            @RequestParam(required = false, name = "productName") String productName,
            @RequestParam(name = "productId") Long productId,
//            @RequestParam(required = false, name = "sort") String sortParamater,
            @RequestParam(required = false, name = "categoryId") Long categoryId,
            @RequestParam(required = false, name = "mrp") Double mrp,
            @RequestParam(required = false, name = "ssp") Double ssp,
            @RequestParam(required = false, name = "ymp") Double ymp,
            @RequestParam(required = false, name = "shortDescription") String shortDescription,
            @RequestParam(required = false, name = "longDescription") String longDescription,
            @RequestParam(required = false, name = "dimensions") String dimensions,
            @RequestParam(required = false, name = "flag", defaultValue = "0") Long flag
    ) {
        HttpSession session = request.getSession(false);

        ProductResponse productResponse = productService.getProductById(productId);
        model.addAttribute("ab", productResponse);

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
        ProductResponse s = productService.updateProduct(productRequest, productId);

        return "redirect:/admin/products";

    }

    @RequestMapping(value = "/admin/products/update-status", method = RequestMethod.GET)
    public String approveProducts(
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        String[] ids = request.getParameterValues("cbox");
        if (ids != null) {
            for (String value : ids) {
                System.out.println(value);
                // 2=>APPROVED
                long id = Long.parseLong(String.valueOf(value));
                productService.updateProductStatus(id);
            }
        }
        return "redirect:/admin/products";
    }
}
