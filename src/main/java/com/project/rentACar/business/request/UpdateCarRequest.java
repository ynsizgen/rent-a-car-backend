package com.project.rentACar.business.request;

import com.project.rentACar.enums.EnumState;
import com.project.rentACar.enums.EnumVehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
    @NotNull
    private int id;
    @NotNull
    private EnumState state;
    @NotNull
    private double dailyPrice;
}
