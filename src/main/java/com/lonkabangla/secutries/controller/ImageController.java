package com.lonkabangla.secutries.controller;

import com.lonkabangla.secutries.entity.Account;
import com.lonkabangla.secutries.entity.ImageEntity;
import com.lonkabangla.secutries.repository.AccountHolderRepo;
import com.lonkabangla.secutries.repository.AccountRepository;
import com.lonkabangla.secutries.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
public class ImageController {
    @Autowired
    private ImageRepository imageRepository;
    private final AccountRepository accountRepository;

    public ImageController(ImageRepository imageRepository, AccountRepository accountRepository) {
        this.imageRepository = imageRepository;
        this.accountRepository = accountRepository;
    }

    @PostMapping("/{id}/upload")
    public ResponseEntity<String> uploadImage(@PathVariable Long id,@RequestParam String name, @RequestParam MultipartFile file) {
        try {
            Optional<Account> account = accountRepository.findById(id);
            if(account.isPresent()){
                ImageEntity image = new ImageEntity();
                image.setName(name);
                image.setContentType(file.getContentType());
                image.setData(file.getBytes());

                ImageEntity imageEntity= imageRepository.save(image);

                Account newAccount = account.get();
                newAccount.setPhoto(imageEntity);
                accountRepository.save(newAccount);
                return ResponseEntity.ok("Image uploaded successfully");
            }

            return ResponseEntity.badRequest().body("Account Not Present uploading image");

        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error uploading image");
        }
    }

    @PostMapping("/{id}/upload/utility")
    public ResponseEntity<String> uploadNid(@PathVariable Long id,@RequestParam String name, @RequestParam MultipartFile file) {
        try {
            Optional<Account> account = accountRepository.findById(id);
            if(account.isPresent()){
                ImageEntity image = new ImageEntity();
                image.setName(name);
                image.setContentType(file.getContentType());
                image.setData(file.getBytes());

                ImageEntity imageEntity= imageRepository.save(image);

                Account newAccount = account.get();
                newAccount.setNid(imageEntity);
                accountRepository.save(newAccount);
                return ResponseEntity.ok("Image uploaded successfully");
            }

            return ResponseEntity.badRequest().body("Account Not Present uploading image");

        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error uploading image");
        }
    }

    @PostMapping("/{id}/upload/nid")
    public ResponseEntity<String> uploadUtility(@PathVariable Long id,@RequestParam String name, @RequestParam MultipartFile file) {
        try {
            Optional<Account> account = accountRepository.findById(id);
            if(account.isPresent()){
                ImageEntity image = new ImageEntity();
                image.setName(name);
                image.setContentType(file.getContentType());
                image.setData(file.getBytes());

                ImageEntity imageEntity= imageRepository.save(image);

                Account newAccount = account.get();
                newAccount.setUtilityBill(imageEntity);
                accountRepository.save(newAccount);
                return ResponseEntity.ok("Image uploaded successfully");
            }

            return ResponseEntity.badRequest().body("Account Not Present uploading image");

        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error uploading image");
        }
    }


    @PostMapping("/{id}/upload/etin")
    public ResponseEntity<String> uploadetin(@PathVariable Long id,@RequestParam String name, @RequestParam MultipartFile file) {
        try {
            Optional<Account> account = accountRepository.findById(id);
            if(account.isPresent()){
                ImageEntity image = new ImageEntity();
                image.setName(name);
                image.setContentType(file.getContentType());
                image.setData(file.getBytes());

                ImageEntity imageEntity= imageRepository.save(image);

                Account newAccount = account.get();
                newAccount.setEtin(imageEntity);
                accountRepository.save(newAccount);
                return ResponseEntity.ok("Image uploaded successfully");
            }

            return ResponseEntity.badRequest().body("Account Not Present uploading image");

        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error uploading image");
        }
    }





//
//    @GetMapping("/image/{id}")
//    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
//        Optional<ImageEntity> optionalImage = imageRepository.findById(id);
//        if (optionalImage.isPresent()) {
//            ImageEntity image = optionalImage.get();
//            return ResponseEntity.ok()
//                    .contentType(MediaType.parseMediaType(image.getContentType()))
//                    .body(image.getData());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Optional<ImageEntity> optionalImage = imageRepository.findById(id);
        if (optionalImage.isPresent()) {
            ImageEntity image = optionalImage.get();

            int httpCacheAgeSeconds = 3600; // Set the caching duration in seconds

            var headers = new HttpHeaders();
            headers.setCacheControl("no-transform, public, max-age=" + httpCacheAgeSeconds);

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.parseMediaType(image.getContentType()))
                    .body(image.getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
