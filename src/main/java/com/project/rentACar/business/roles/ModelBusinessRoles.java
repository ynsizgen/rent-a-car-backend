package com.project.rentACar.business.roles;

import com.project.rentACar.core.utilities.exceptions.BusinessException;
import com.project.rentACar.dataAccess.ModelRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
@Data
@AllArgsConstructor
public class ModelBusinessRoles {
    private ModelRepository modelRepository;
    public void checkIfModelNameExists(String name){
        if (this.modelRepository.existsByName(name)) {
            throw new BusinessException("Model name already exists!");
        }
    }
}
