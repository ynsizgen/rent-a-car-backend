package com.project.rentACar;

import com.project.rentACar.core.utilities.exceptions.BusinessException;
import com.project.rentACar.core.utilities.exceptions.ProblemDetails;
import com.project.rentACar.core.utilities.exceptions.ValidateProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.persistence.EntityNotFoundException;
import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidateException(MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidateProblemDetails validateProblemDetails = new ValidateProblemDetails();
		validateProblemDetails.setMessage("VALIDATION.EXCEPTION");
		validateProblemDetails.setValidationErrors(new HashMap<String,String>());

		for (FieldError fieldError: methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validateProblemDetails.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		return validateProblemDetails;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ProblemDetails handleEntityIdException(EntityNotFoundException entityNotFoundException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(entityNotFoundException.getMessage());

		return problemDetails;
	}



	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
