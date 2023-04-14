package com.project.rentACar.business.abstracts;

import com.project.rentACar.business.request.CreateCarRequest;
import com.project.rentACar.business.request.UpdateCarRequest;
import com.project.rentACar.business.response.GetAllCarsResponse;
import com.project.rentACar.business.response.GetByIdCarResponse;
import com.project.rentACar.business.response.GetByModelIdCarResponse;

import java.util.List;

public interface CarService {
    List<GetAllCarsResponse> getAll();

    void add(CreateCarRequest createCarRequest);

    void update(UpdateCarRequest updateCarRequest);

    List<GetByModelIdCarResponse> getByModelId(int id);

    List<GetByIdCarResponse> findAllByStateTrue();

    GetByIdCarResponse getById(int id);

    void delete(int id);
}
