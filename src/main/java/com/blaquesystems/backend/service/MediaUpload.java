package com.blaquesystems.backend.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class MediaUpload {

    @Value("${cloudinary.cloud_name}")
    private String cloud_name;

    @Value("${cloudinary.api_key}")
    private String api_key;

    @Value("${cloudinary.api_secret}")
    private String api_secret;

    public String uploadMedia(MultipartFile file) throws IOException {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", cloud_name);
        config.put("api_key", api_key);
        config.put("api_secret", api_secret);
        Cloudinary cloudinary = new Cloudinary(config);

        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());

        System.out.println(uploadResult.get("url"));

        return uploadResult.get("url").toString();
    }
}
