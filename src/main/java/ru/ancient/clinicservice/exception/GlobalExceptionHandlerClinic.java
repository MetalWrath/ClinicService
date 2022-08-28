package ru.ancient.clinicservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerClinic {

    @ExceptionHandler
    public ResponseEntity<ExceptionDataDTO> clinicNotFoundById(ClinicNotFoundByIdException clinicNotFoundByIdException){
        ExceptionDataDTO exceptionDataDTO = new ExceptionDataDTO();
        exceptionDataDTO.setDescription(clinicNotFoundByIdException.getMessage());
        exceptionDataDTO.setHttpStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionDataDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDataDTO> clinicNotFoundById(Exception exception){
        ExceptionDataDTO exceptionDataDTO = new ExceptionDataDTO();
        exceptionDataDTO.setDescription(exception.getMessage());
        exceptionDataDTO.setHttpStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionDataDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDataDTO> listOfClinicsNotFound(ListOfClinicsNotFoundException listOfClinicsNotFoundException){
        ExceptionDataDTO exceptionDataDTO  = new ExceptionDataDTO();
        exceptionDataDTO.setHttpStatus(HttpStatus.NOT_FOUND);
        exceptionDataDTO.setDescription(listOfClinicsNotFoundException.getMessage());
        return new ResponseEntity<>(exceptionDataDTO, HttpStatus.NOT_FOUND);
    }



}
