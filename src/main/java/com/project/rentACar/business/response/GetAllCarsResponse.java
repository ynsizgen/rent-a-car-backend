package com.project.rentACar.business.response;

import com.project.rentACar.enums.EnumVehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarsResponse {


    private int id;
    private Enum state;
    private String plates;
    private double dailyPrice;
    private int modelYear;
    private int seats;
    private boolean manuelAuto;
    private EnumVehicleType enumVehicleType;
    private LocalDateTime createDate;
    private String brandName;
    private String modelName;

}
