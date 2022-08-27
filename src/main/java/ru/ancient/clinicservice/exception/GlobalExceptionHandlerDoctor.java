package ru.ancient.clinicservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerDoctor {


    @ExceptionHandler
    public ResponseEntity<ExceptionDataDTO> doctorNotFoundById(DoctorNotFoundByIdException doctorNotFoundByIdException){
        ExceptionDataDTO exceptionDataDTO = new ExceptionDataDTO();
        exceptionDataDTO.setHttpStatus(HttpStatus.NOT_FOUND);
        exceptionDataDTO.setDescription(doctorNotFoundByIdException.getMessage());

        return new ResponseEntity<>(exceptionDataDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDataDTO> listOfDoctorNotFound(ListOfDoctorsNotFoundException listOfDoctorsNotFoundException){
        ExceptionDataDTO exceptionDataDTO = new ExceptionDataDTO();
        exceptionDataDTO.setHttpStatus(HttpStatus.NOT_FOUND);
        exceptionDataDTO.setDescription(listOfDoctorsNotFoundException.getMessage());

        return new ResponseEntity<>(exceptionDataDTO, HttpStatus.NOT_FOUND);
    }



}
