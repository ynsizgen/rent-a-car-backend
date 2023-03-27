package com.project.rentACar.webApi.controllers;

import com.project.rentACar.business.abstracts.BrandService;
import com.project.rentACar.business.request.CreateBrandRequest;
import com.project.rentACar.business.request.UpdateBrandRequest;
import com.project.rentACar.business.response.GetAllBrandsResponse;
import com.project.rentACar.business.response.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<GetAllBrandsResponse>> getAll(){
        return new ResponseEntity<>(this.brandService.getAll(), OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<GetByIdBrandResponse> getById(@PathVariable int id){
        return new ResponseEntity<>(this.brandService.getById(id),OK);
    }

    @PostMapping("/addBrand")
    public ResponseEntity<Boolean> add(@RequestBody @Valid CreateBrandRequest createBrandRequest){
       return new ResponseEntity<>(this.brandService.add(createBrandRequest), CREATED);
    }

    @DeleteMapping("/deleteBrand/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id){
       return new ResponseEntity<>(this.brandService.delete(id), OK);
    }

    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest){
        return new ResponseEntity<>(this.brandService.update(updateBrandRequest), OK);
    }
}
