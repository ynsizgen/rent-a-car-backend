package com.project.rentACar.business.abstracts;

import com.project.rentACar.business.request.CreateBrandRequest;
import com.project.rentACar.business.request.UpdateBrandRequest;
import com.project.rentACar.business.response.GetAllBrandsResponse;
import com.project.rentACar.business.response.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    boolean add(CreateBrandRequest createBrandRequest);
    GetByIdBrandResponse getById(String id);
    boolean delete(String id);
    boolean update(UpdateBrandRequest updateBrandRequest);

}
