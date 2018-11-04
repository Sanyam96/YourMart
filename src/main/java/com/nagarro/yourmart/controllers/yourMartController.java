package com.nagarro.yourmart.controllers;

import com.nagarro.yourmart.dtos.*;
import com.nagarro.yourmart.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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









    //    SELLERS
    @RequestMapping(value = "/admin/sellers", method = RequestMethod.GET)
    public String viewSellers(
            Model model,
            HttpServletResponse response,
            HttpServletRequest request,
            @RequestParam(required = false, name = "limit", defaultValue = "10") Long limit,
            @RequestParam(required = false, name = "offset", defaultValue = "0") Long offset,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "sellerId", required = false) Long sellerId,
            @RequestParam(required = false, name = "companyName") String companyName,
            @RequestParam(required = false, name = "ownerName") String ownerName,
            @RequestParam(required = false, name = "telephoneNumber") Long telephoneNumber,
            @RequestParam(required = false, name = "sellerStatusId") Long sellerStatusId //filter
    ) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            List<SellerResponse> sellerResponses = sellerService.getAllSellersByParams(offset, limit, sortBy, sellerId, sellerStatusId, companyName, ownerName, telephoneNumber);
            model.addAttribute("ab", sellerResponses);
            return "sellerList";
        }
        return "redirect:/admin/login";
    }


    @RequestMapping(value = "/admin/sel", method = RequestMethod.GET)
    public String updateSeller(
            Model model,
            HttpServletResponse response,
            HttpServletRequest request,
            @RequestParam(value = "sellerId", required = false) Long sellerId,
            @RequestParam(required = false, name = "flag", defaultValue = "0") Long flag,
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

        SellerRequest sellerRequest = new SellerRequest();
        sellerRequest.setCompanyName(companyName);
        sellerRequest.setOwnerName(ownerName);
        sellerRequest.setAddress(address);
        sellerRequest.setEmailAddress(emailAddress);
        sellerRequest.setTelephoneNumber(telephoneNumber);
        sellerRequest.setGstNumber(gstNumber);
        SellerResponse s = sellerService.updateSeller(sellerRequest, sellerId);
        return "redirect:/admin/sellers";
    }

    @RequestMapping(value = "/admin/seller/{sellerId}", method = RequestMethod.GET)
    public String viewSeller(
            Model model,
            HttpServletResponse response,
            HttpServletRequest request,
            @PathVariable("sellerId") Long sellerId,
            @RequestParam(required = false, name = "flag", defaultValue = "0") Long flag,
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
        if (sellerResponse != null) {
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
    }


    @RequestMapping(value = "/admin/seller/update-seller", method = RequestMethod.GET)
    public String updateSellerStatus(
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        String[] ids = request.getParameterValues("cbox");
        if (ids != null) {
            for (String value : ids) {
                System.out.println(value);
                // 4=>APPROVED
                long id = Long.parseLong(String.valueOf(value));
                sellerService.updateSellerStatus(id);
            }
        }
        return "redirect:/admin/sellers";
    }


}
