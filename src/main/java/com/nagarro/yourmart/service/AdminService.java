package com.nagarro.yourmart.service;

import com.nagarro.yourmart.domains.Admin;
import com.nagarro.yourmart.dtos.AdminResponse;
import com.nagarro.yourmart.exceptions.YourMartResourceNotFoundException;
import com.nagarro.yourmart.repository.AdminRepository;
import com.nagarro.yourmart.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sanyam Goel created on 1/11/18
 */
@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Transactional
    public AdminResponse authenticate(String username, String password) {
        Admin admin = adminRepository.authenticateAdmin(username, password);
        AdminResponse adminResponse = Utility.convertModel(admin, AdminResponse.class);

        if (admin == null || adminResponse == null) {
            throw new YourMartResourceNotFoundException("Admin unauthenticated");
        }
        return adminResponse;
    }
}
