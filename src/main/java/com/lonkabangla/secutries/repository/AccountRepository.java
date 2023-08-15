package com.lonkabangla.secutries.repository;

import com.lonkabangla.secutries.Enum.Status;
import com.lonkabangla.secutries.dto.AccountDto;
import com.lonkabangla.secutries.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {
    List<Account> findByStatus(Status status);
}
