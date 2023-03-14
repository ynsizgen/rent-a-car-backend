package com.project.rentACar.webApi.controllers;

import com.project.rentACar.business.abstracts.ModelService;
import com.project.rentACar.business.request.CreateModelRequest;
import com.project.rentACar.business.response.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelController {
    private ModelService modelService;

    @GetMapping("/getAll")
    @ResponseStatus(OK)
    public ResponseEntity<List<GetAllModelsResponse>> getAll(){
        return new ResponseEntity<>(this.modelService.getAll(), OK);
    }

    @PostMapping("/add")
    @ResponseStatus(CREATED)
    public boolean add(CreateModelRequest createModelRequest){
        return this.modelService.add(createModelRequest);

    }

}
