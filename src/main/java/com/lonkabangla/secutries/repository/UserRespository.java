package com.lonkabangla.secutries.repository;

import com.lonkabangla.secutries.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends JpaRepository<User,Long> {

    Optional<User> findByEmailAndPassword(String email, String password);
}
