package com.lonkabangla.secutries.service;


import com.lonkabangla.secutries.entity.User;
import com.lonkabangla.secutries.repository.UserRespository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRespository userRespository;

    public UserService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    public User save(User user) {
        return userRespository.save(user);
    }

    public String login(User user) {
        Optional<User> isUser = userRespository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (isUser.isPresent()) {
            return "login";
        } else {
            return "no";
        }
    }
}
