package com.project.rentACar.webApi.controllers;

import com.project.rentACar.business.abstracts.BrandService;
import com.project.rentACar.business.request.CreateBrandRequest;
import com.project.rentACar.business.request.UpdateBrandRequest;
import com.project.rentACar.business.response.GetAllBrandsResponse;
import com.project.rentACar.business.response.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandController {

    private BrandService brandService;

    @GetMapping("/getAll")
    @ResponseStatus(OK)
    public List<GetAllBrandsResponse> getAll(){
        return this.brandService.getAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(OK)
    public GetByIdBrandResponse getById(@PathVariable int id){
        return this.brandService.getById(id);
    }

    @PostMapping("/addBrand")
    @ResponseStatus(OK)
    public Boolean add(@RequestBody @Valid CreateBrandRequest createBrandRequest){
       return this.brandService.add(createBrandRequest);
    }

    @DeleteMapping("/deleteBrand/{id}")
    public Boolean delete(@PathVariable int id){
       return this.brandService.delete(id);
    }

    @PutMapping
    public Boolean update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest){
        return this.brandService.update(updateBrandRequest);
    }
}
