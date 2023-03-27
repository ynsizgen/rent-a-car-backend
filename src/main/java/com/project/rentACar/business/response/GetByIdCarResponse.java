package com.project.rentACar.business.response;

import com.project.rentACar.enums.EnumVehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCarResponse {

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
