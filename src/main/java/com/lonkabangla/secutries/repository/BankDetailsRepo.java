package com.lonkabangla.secutries.repository;

import com.lonkabangla.secutries.entity.BankAccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDetailsRepo extends JpaRepository<BankAccountDetails,Long> {


}
