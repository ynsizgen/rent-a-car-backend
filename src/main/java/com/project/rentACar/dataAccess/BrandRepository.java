package com.project.rentACar.dataAccess;

import com.project.rentACar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
    boolean existsByName(String name); //spring jpa keywords
}
