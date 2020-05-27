package com.netcracker.edu.back.backend.service.implementation;

import com.netcracker.edu.back.backend.service.StorageService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageServiceImpl implements StorageService {

    private final Path rootLocation = Paths.get("backend/src/main/resources/images");

    @Override
    public void deleteProductImage(String name) {
        try {
            Path file = Paths.get(rootLocation+"/products/"+name);
            File file1 = new File(file.toString());
            file1.delete();
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }

    @Override
    public boolean storeProductImage(MultipartFile file) {
        try{
            Path productPath = Paths.get(rootLocation+"/products/"+file.getOriginalFilename()).toAbsolutePath();
            Files.copy(file.getInputStream(), productPath);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Resource getProductImage(String name) {
        try {
            Path file = Paths.get(rootLocation+"/products/"+name);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

    @Override
    public boolean storeUserImage(MultipartFile file) {
        try{
            Path productPath = Paths.get(rootLocation+"/users/"+file.getOriginalFilename()).toAbsolutePath();
            Files.copy(file.getInputStream(), productPath);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Resource getUserImage(String name) {
        try {
            Path file = Paths.get(rootLocation+"/users/"+name);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL to load image!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }
}
