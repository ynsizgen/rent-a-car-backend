package com.project.rentACar.business.request;

import com.project.rentACar.enums.EnumState;
import com.project.rentACar.enums.EnumVehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarRequest {
    @NotNull
    private EnumState state;
    @NotNull
    @Size(min = 7, max = 10)
    private String plates;
    @NotNull
    private double dailyPrice;
    @NotNull
    private int modelYear;
    @NotNull
    private int seats;
    @NotNull
    private boolean manuelAuto;

    private EnumVehicleType enumVehicleType;

    private int modelId;

}
