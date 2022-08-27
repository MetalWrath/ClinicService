package ru.ancient.clinicservice.exception;

public class ListOfDoctorsNotFoundException extends RuntimeException {
    public ListOfDoctorsNotFoundException(String message) {
        super(message);
    }
}
