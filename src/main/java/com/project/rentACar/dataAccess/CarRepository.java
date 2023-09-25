package com.project.rentACar.dataAccess;

import com.project.rentACar.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car,UUID> {

    boolean existsByPlates(String plates);

    List<Car> getByModelId(int id);

    @Query("select c from Car c where c.state = 0")
    List<Car> findAllByStateTrue();

    @Query("select c from Car c where c.plates=:plate")
    Car getByPlate(String plate);
}
