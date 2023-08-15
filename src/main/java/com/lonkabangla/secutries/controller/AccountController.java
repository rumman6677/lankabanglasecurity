package com.lonkabangla.secutries.controller;

import com.lonkabangla.secutries.dto.AccountDto;
import com.lonkabangla.secutries.entity.Account;
import com.lonkabangla.secutries.entity.ImageEntity;
import com.lonkabangla.secutries.repository.AccountRepository;
import com.lonkabangla.secutries.repository.ImageRepository;
import com.lonkabangla.secutries.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ImageRepository imageRepository;

    @PostMapping("/accounts")
    public ResponseEntity<?> createAccountWithImage(@RequestBody AccountDto accountDto) {

        Account account = accountService.save(accountDto);
        return new ResponseEntity<>(account.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccount(@PathVariable Long id){
        Account account = accountService.getAccountById(id).get();
        AccountDto dto = AccountDto.form(account);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @GetMapping("/list/all")
    public ResponseEntity<?> getAllAccounts(){
        return new ResponseEntity<>(accountService.findAllAccount(),HttpStatus.OK);
    }

    @GetMapping("/update/status/{id}")
    public  ResponseEntity<?> updateStatus(@PathVariable Long id) {
        return new ResponseEntity<>(accountService.updateStatus(id),HttpStatus.OK);
    }

    @GetMapping("/activatedUser/{id}")
    public ResponseEntity<?> activedUSer(@PathVariable Long id) {
        return new ResponseEntity<>(accountService.activedUser(id),HttpStatus.OK);
    }

    @GetMapping("/active/customer")
    public ResponseEntity<?> allActiveUser(){
        return new ResponseEntity<>(accountService.allActiveUser(),HttpStatus.OK);
    }


    @GetMapping("/list/review/account")
    public ResponseEntity<?> getReviewAccountList(){
        return new ResponseEntity<>(accountService.getReviewAccountList(),HttpStatus.OK);
    }

    @GetMapping("/list/check/account")
    public ResponseEntity<?> getCheckAccountList(){
        return new ResponseEntity<>(accountService.getCheckAccountList(),HttpStatus.OK);
    }

}
