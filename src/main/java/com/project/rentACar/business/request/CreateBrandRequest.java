package com.project.rentACar.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBrandRequest {

    @NotNull(message = "İsim girilmedi")
    @NotEmpty
    @NotBlank
    @Size(min = 3 , max = 20)
    private String name;

}
