package com.nagarro.yourmart.service;

import com.nagarro.yourmart.repository.YourMartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sanyam Goel created on 29/10/18
 */
@Service
public class YourMartService {

    @Autowired
    YourMartRepository yourMartRepository;

}
