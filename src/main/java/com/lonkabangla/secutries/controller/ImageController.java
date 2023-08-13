package com.lonkabangla.secutries.controller;

import com.lonkabangla.secutries.entity.ImageEntity;
import com.lonkabangla.secutries.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam String name, @RequestParam MultipartFile file) {
        try {
            ImageEntity image = new ImageEntity();
            image.setName(name);
            image.setContentType(file.getContentType());
            image.setData(file.getBytes());

            imageRepository.save(image);

            return ResponseEntity.ok("Image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error uploading image");
        }
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Optional<ImageEntity> optionalImage = imageRepository.findById(id);
        if (optionalImage.isPresent()) {
            ImageEntity image = optionalImage.get();
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(image.getContentType()))
                    .body(image.getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
