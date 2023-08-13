package com.lonkabangla.secutries.repository;

import com.lonkabangla.secutries.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageEntity,Long> {
    
}
