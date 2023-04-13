package com.project.rentACar.business.abstracts;

import com.project.rentACar.business.request.CreateBrandRequest;
import com.project.rentACar.business.request.UpdateBrandRequest;
import com.project.rentACar.business.response.GetAllBrandsResponse;
import com.project.rentACar.business.response.GetByIdBrandResponse;
import com.project.rentACar.business.response.GetByNameBrandResponse;
import com.project.rentACar.entities.Brand;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    boolean add(CreateBrandRequest createBrandRequest);
    GetByIdBrandResponse getById(int id);
    boolean delete(int id);
    boolean update(UpdateBrandRequest updateBrandRequest);
    Brand getByName(String name);

}
