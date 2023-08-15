package com.lonkabangla.secutries.repository;

import com.lonkabangla.secutries.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Long> {
}
