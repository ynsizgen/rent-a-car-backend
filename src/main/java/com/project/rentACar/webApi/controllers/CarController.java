package com.project.rentACar.webApi.controllers;

import com.project.rentACar.business.abstracts.CarService;
import com.project.rentACar.business.request.CreateCarRequest;
import com.project.rentACar.business.request.UpdateCarRequest;
import com.project.rentACar.business.response.GetAllCarsResponse;
import com.project.rentACar.business.response.GetByIdCarResponse;
import com.project.rentACar.business.response.GetByModelIdCarResponse;
import com.project.rentACar.business.response.GetByPlateCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
@CrossOrigin
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
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable UUID id){
        this.carService.delete(id);
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdCarResponse getById(@PathVariable UUID id){
        return this.carService.getById(id);
    }

    @GetMapping("/getByPlate/{plate}")
    @ResponseStatus(HttpStatus.OK)
    public GetByPlateCarResponse getByPlate(@PathVariable String plate){
        return this.carService.getByPlate(plate);
    }

    @GetMapping("/getByModelId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetByModelIdCarResponse> getByModelId(@PathVariable int id){
        return this.carService.getByModelId(id);
    }

    @GetMapping("/findAllByStateTrue")
    @ResponseStatus(HttpStatus.OK)
    public List<GetByIdCarResponse> findAllByStateTrue(){
        return this.carService.findAllByStateTrue();
    }
}
