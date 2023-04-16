package com.project.rentACar.business.concretes;

import com.project.rentACar.business.abstracts.BrandService;
import com.project.rentACar.business.abstracts.CarService;
import com.project.rentACar.business.abstracts.ModelService;
import com.project.rentACar.business.request.CreateBrandRequest;
import com.project.rentACar.business.request.CreateCarRequest;
import com.project.rentACar.business.request.CreateModelRequest;
import com.project.rentACar.business.request.UpdateCarRequest;
import com.project.rentACar.business.response.*;
import com.project.rentACar.business.roles.CarBusinessRoles;
import com.project.rentACar.core.utilities.mappers.ModelMapperService;
import com.project.rentACar.dataAccess.CarRepository;
import com.project.rentACar.entities.Brand;
import com.project.rentACar.entities.Car;
import com.project.rentACar.entities.Model;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private CarRepository carRepository;
    private ModelMapperService modelMapperService;
    private BrandService brandService;
    private ModelService modelService;

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
    @Transactional
    public void add(CreateCarRequest createCarRequest) {
        this.carBusinessRoles.checkIfPlateExists(createCarRequest.getPlates());

        Brand brand = brandService.getByName(createCarRequest.getBrandName());

        if (brand == null) {
            brand = new Brand();
            brand.setName(createCarRequest.getBrandName());
        }

        Model model= this.modelService.getByName(createCarRequest.getModelName());

        if (model == null) {
            model = new Model();
            model.setName(createCarRequest.getModelName());
            model.setBrand(brand);

        }

        Car car = this.modelMapperService.forRequest().map(createCarRequest,Car.class);
        car.setModel(model);

        this.carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {
        Car existingCar = this.carRepository.getById(updateCarRequest.getId());
        existingCar.setDailyPrice(updateCarRequest.getDailyPrice());
        existingCar.setState(updateCarRequest.getState());
        this.carRepository.save(existingCar);
    }

    @Override
    public List<GetByModelIdCarResponse> getByModelId(int id) {
        List<Car> cars = this.carRepository.getByModelId(id);
        List<GetByModelIdCarResponse> getByModelIdCarResponses = cars.stream().map( car -> this.modelMapperService.forResponse().map(car,GetByModelIdCarResponse.class)).collect(Collectors.toList());
        return getByModelIdCarResponses;
    }

    @Override
    public List<GetByIdCarResponse> findAllByStateTrue() {
        List<Car> cars = this.carRepository.findAllByStateTrue();
        List<GetByIdCarResponse> getByIdCarResponses = cars.stream().map(car -> this.modelMapperService.forResponse().map(car,GetByIdCarResponse.class)).collect(Collectors.toList());
        return getByIdCarResponses;
    }

    @Override
    public GetByIdCarResponse getById(int id) {
        Car car = this.carRepository.getById(id);
        GetByIdCarResponse getByIdCarResponse = this.modelMapperService.forResponse().map(car,GetByIdCarResponse.class);
        return getByIdCarResponse;
    }

    @Override
    public void delete(int id) {
        this.carRepository.delete(this.carRepository.getById(id));
    }

}
