package com.project.rentACar.business.roles;

import com.project.rentACar.core.utilities.exceptions.BusinessException;
import com.project.rentACar.dataAccess.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarBusinessRoles {
    private CarRepository carRepository;

    public void checkIfPlateExists(String plates) {
        if (this.carRepository.existsByPlates(plates)) {
            throw new BusinessException("Plate already exists.!");
        }
    }
}
