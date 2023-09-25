package com.project.rentACar.business.abstracts;

import com.project.rentACar.business.request.CreateCarRequest;
import com.project.rentACar.business.request.UpdateCarRequest;
import com.project.rentACar.business.response.GetAllCarsResponse;
import com.project.rentACar.business.response.GetByIdCarResponse;
import com.project.rentACar.business.response.GetByModelIdCarResponse;
import com.project.rentACar.business.response.GetByPlateCarResponse;

import java.util.List;
import java.util.UUID;

public interface CarService {
    List<GetAllCarsResponse> getAll();

    void add(CreateCarRequest createCarRequest);

    void update(UpdateCarRequest updateCarRequest);

    List<GetByModelIdCarResponse> getByModelId(int id);

    List<GetByIdCarResponse> findAllByStateTrue();

    GetByIdCarResponse getById(UUID id);

    void delete(UUID id);

    GetByPlateCarResponse getByPlate(String id);
}
