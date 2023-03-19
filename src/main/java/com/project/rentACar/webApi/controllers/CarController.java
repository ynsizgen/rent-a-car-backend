package com.project.rentACar.webApi.controllers;

import com.project.rentACar.business.abstracts.CarService;
import com.project.rentACar.business.request.CreateCarRequest;
import com.project.rentACar.business.request.UpdateCarRequest;
import com.project.rentACar.business.response.GetAllCarsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {
    private CarService carService;

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCarsResponse> getAll() {
        return this.carService.getAll();
    }

    @PostMapping("/addCar")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateCarRequest createCarRequest) {
        this.carService.add(createCarRequest);
    }

    @PutMapping("/updateCar")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateCarRequest updateCarRequest) {
        this.carService.update(updateCarRequest);
    }
}
