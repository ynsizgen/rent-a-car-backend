package com.project.rentACar.business.response;

import com.project.rentACar.enums.EnumVehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCarResponse {

    private UUID id;
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
