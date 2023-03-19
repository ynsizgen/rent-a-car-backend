package com.project.rentACar.dataAccess;

import com.project.rentACar.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {
    boolean existsByPlates(String plates);
}
