package com.project.rentACar.business.abstracts;

import com.project.rentACar.business.request.CreateModelRequest;
import com.project.rentACar.business.response.GetAllModelsResponse;
import com.project.rentACar.business.response.GetByNameModelResponse;
import com.project.rentACar.entities.Brand;
import com.project.rentACar.entities.Model;

import java.util.List;

public interface ModelService {

    List<GetAllModelsResponse> getAll();
    boolean add(CreateModelRequest createModelRequest);

    Model getByName(String modelName);
}
