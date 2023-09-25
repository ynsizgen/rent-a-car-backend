package com.project.rentACar.business.request;

import com.project.rentACar.enums.EnumState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
    @NotNull
    private UUID id;
    @NotNull
    private EnumState state;
    @NotNull
    private double dailyPrice;
}
