package ru.ancient.clinicservice.exception;

public class DoctorNotFoundByIdException extends RuntimeException{
    public DoctorNotFoundByIdException(String message) {
        super(message);
    }
}
