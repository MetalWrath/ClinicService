package ru.ancient.clinicservice.exception;

public class ListOfClinicsNotFoundException extends RuntimeException{
    public ListOfClinicsNotFoundException(String message) {
        super(message);
    }
}
