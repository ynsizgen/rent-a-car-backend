package com.project.rentACar.business.concretes;

import com.project.rentACar.business.abstracts.CarService;
import com.project.rentACar.business.request.CreateCarRequest;
import com.project.rentACar.business.request.UpdateCarRequest;
import com.project.rentACar.business.response.GetAllCarsResponse;
import com.project.rentACar.business.roles.CarBusinessRoles;
import com.project.rentACar.core.utilities.mappers.ModelMapperService;
import com.project.rentACar.dataAccess.CarRepository;
import com.project.rentACar.entities.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private CarRepository carRepository;
    private ModelMapperService modelMapperService;

    private CarBusinessRoles carBusinessRoles;
    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = this.carRepository.findAll();
        List<GetAllCarsResponse> getAllCarsResponses = cars.stream().map(car -> this.modelMapperService
                        .forResponse()
                        .map(car, GetAllCarsResponse.class))
                        .collect(Collectors.toList());
        return getAllCarsResponses;
    }

    @Override
    public void add(CreateCarRequest createCarRequest) {
        this.carBusinessRoles.checkIfPlateExists(createCarRequest.getPlates());
        Car car = this.modelMapperService.forRequest().map(createCarRequest,Car.class);

        this.carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {
        Car existingCar = this.carRepository.getById(updateCarRequest.getId());
        existingCar.setDailyPrice(updateCarRequest.getDailyPrice());
        existingCar.setState(updateCarRequest.getState());
        this.carRepository.save(existingCar);
    }

}
