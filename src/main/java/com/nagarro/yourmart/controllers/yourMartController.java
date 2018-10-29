package com.nagarro.yourmart.controllers;

import com.nagarro.yourmart.dtos.ResponseModel;
import com.nagarro.yourmart.service.YourMartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sanyam Goel created on 29/10/18
 */
@RequestMapping(value = "/v1")
@RestController
public class yourMartController extends RestResponseHandler {

    @Autowired
    YourMartService yourMartService;

    @RequestMapping(method = RequestMethod.GET, value = "/hello", produces = "application/json")
    public ResponseEntity<ResponseModel<String>> getAllData() {
        return super.responseStandardizer("Hello");
    }

}
