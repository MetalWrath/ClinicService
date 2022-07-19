package ru.ancient.clinicservice.exception;

public class ClinicNotFoundByIdException extends RuntimeException{
    public ClinicNotFoundByIdException(String message) {
        super(message);
    }
}
