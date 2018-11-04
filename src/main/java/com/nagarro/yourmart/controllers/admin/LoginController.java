package com.nagarro.yourmart.controllers.admin;

import com.nagarro.yourmart.dtos.AdminResponse;
import com.nagarro.yourmart.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Sanyam Goel created on 4/11/18
 */
@Controller
public class LoginController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/admin/login")
    public String loginPage(ModelMap modelMap) {
        return "login";
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public String getAdminLoggedIn(
            ModelMap model,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        AdminResponse admin = adminService.authenticate(username, password);
        request.getSession().setAttribute("admin", admin);
        return "redirect:/admin/home";
    }

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public String homePage(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("admin") != null) {
            return "home";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/logout", method = RequestMethod.POST)
    public String adminLogout(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("admin") != null) {
            session.setAttribute("admin", null);
        }
        return "redirect:/admin/login";
    }
}
