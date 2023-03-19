package com.project.rentACar.business.roles;

import com.project.rentACar.core.utilities.exceptions.BusinessException;
import com.project.rentACar.dataAccess.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRoles {
    private BrandRepository brandRepository;

    public void checkIfBrandNameExists(String name) {
        if (this.brandRepository.existsByName(name)) {
            throw new BusinessException("Brand already exists.");
        }
    }
}
