package com.nagarro.yourmart.controllers;

import com.nagarro.yourmart.domains.Admin;
import com.nagarro.yourmart.dtos.ResponseModel;
import com.nagarro.yourmart.service.AdminService;
import com.nagarro.yourmart.service.YourMartService;
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

    @RequestMapping(method = RequestMethod.GET, value = "/hello", produces = "application/json")
    public ResponseEntity<ResponseModel<String>> getAllData() {
        return super.responseStandardizer("Hello");
    }

    // jsp
//    @RequestMapping(value = "/helloo")
//    public String hello(
//            Model model,
//            @RequestParam(value="name", required=false, defaultValue="World") String name
//    ) {
//        model.addAttribute("name", name);
//        return "hello";
//    }


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
        Admin admin = adminService.authenticate(username,password);
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

}
