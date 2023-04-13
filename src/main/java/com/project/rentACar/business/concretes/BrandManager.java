package com.project.rentACar.business.concretes;

import com.project.rentACar.business.request.CreateBrandRequest;
import com.project.rentACar.business.request.UpdateBrandRequest;
import com.project.rentACar.business.response.GetAllBrandsResponse;
import com.project.rentACar.business.response.GetByIdBrandResponse;
import com.project.rentACar.business.response.GetByNameBrandResponse;
import com.project.rentACar.business.roles.BrandBusinessRoles;
import com.project.rentACar.core.utilities.mappers.ModelMapperService;
import com.project.rentACar.entities.Brand;
import com.project.rentACar.business.abstracts.BrandService;
import com.project.rentACar.dataAccess.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRoles brandBusinessRoles;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = this.brandRepository.findAll();
        List<GetAllBrandsResponse> getAllBrandsResponses = brands.stream()
                .map(brand -> this.modelMapperService.forResponse().map(brand,GetAllBrandsResponse.class))
                .collect(Collectors.toList());
        return getAllBrandsResponses;
    }

    @Override
    public boolean add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRoles.checkIfBrandNameExists(createBrandRequest.getName());
        Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
        return true;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.getById(id);
        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public boolean delete(int id) {
        this.brandRepository.delete(this.brandRepository.getById(id));
        return true;
    }

    @Override
    public boolean update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
        return true;
    }

    @Override
    public Brand getByName(String name) {
        Brand brand = this.brandRepository.getByName(name);
        return brand;
    }

}
