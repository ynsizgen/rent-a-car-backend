package com.project.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
