package com.lonkabangla.secutries.controller;


import com.lonkabangla.secutries.dto.UserDto;
import com.lonkabangla.secutries.entity.User;
import com.lonkabangla.secutries.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> userRegister(@RequestBody User user){
        User saveUser = userService.save(user);

        return new ResponseEntity<>(saveUser, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody User user){
        String s = userService.login(user);
        if(Objects.equals(s,"login")){
            return new ResponseEntity<>("login",HttpStatus.OK);
        }
        return new ResponseEntity<>("login",HttpStatus.BAD_REQUEST);
    }
}
