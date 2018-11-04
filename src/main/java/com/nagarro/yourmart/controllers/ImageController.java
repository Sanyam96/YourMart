package com.nagarro.yourmart.controllers;

import com.nagarro.yourmart.dtos.ImageRequest;
import com.nagarro.yourmart.dtos.ImageResponse;
import com.nagarro.yourmart.dtos.ResponseModel;
import com.nagarro.yourmart.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sanyam Goel created on 4/11/18
 */
@RequestMapping(value = "/api/v1/")
@RestController
public class ImageController extends RestResponseHandler {

    @Autowired
    private ImageService imageService;

    @RequestMapping(method = RequestMethod.GET, value = "/images/{productId}", produces = "application/json")
    public ResponseEntity<ResponseModel<List<ImageResponse>>> getImagesById(
            @PathVariable("id") long id
    ) {
        List<ImageResponse> imageResponse = imageService.getAllImagesByProductId(id);
        return super.responseStandardizer(imageResponse);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/image", produces = "application/json")
    public ResponseEntity<ResponseModel<String>> uploadImage(
            @RequestBody ImageRequest imageRequest
    ) {
        String imageResponse = imageService.uploadImage(imageRequest);
        return super.responseStandardizer(imageResponse);
    }
}
