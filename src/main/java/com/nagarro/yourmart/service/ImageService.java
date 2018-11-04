package com.nagarro.yourmart.service;

import com.nagarro.yourmart.domains.Image;
import com.nagarro.yourmart.dtos.ImageResponse;
import com.nagarro.yourmart.exceptions.YourMartResourceNotFoundException;
import com.nagarro.yourmart.repository.ImageRepository;
import com.nagarro.yourmart.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Sanyam Goel created on 4/11/18
 */
@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ProductService productService;

    @Transactional
    public List<ImageResponse> getAllImagesByProductId(long productId) {
        List<Image> images = imageRepository.getImagesByProductId(productId);
        List<ImageResponse> imageResponseList = Utility.convertModelList(images, ImageResponse.class);

        if (images == null || imageResponseList == null) {
            throw new YourMartResourceNotFoundException("Image list not found");
        }
        return imageResponseList;
    }

    @Transactional
    public String uploadImage(long productId, MultipartFile imageFile) {
        Image image = new Image();
        try {
            image.setImage(imageFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        image.setProducts(productService.getProductByIdToSetProductId(productId));
        imageRepository.create(image);

        return "Image Added";

    }

}
