package com.lonkabangla.secutries.controller;

import com.lonkabangla.secutries.entity.BOAccount;
import com.lonkabangla.secutries.repository.BOAccountRepoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BOController {

    private final BOAccountRepoRepo formRepository;

    public BOController(BOAccountRepoRepo formRepository) {
        this.formRepository = formRepository;
    }


    @PostMapping
    public ResponseEntity<?> createForm(@RequestBody BOAccount formData) {
        BOAccount account = formRepository.save(formData);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }



}
