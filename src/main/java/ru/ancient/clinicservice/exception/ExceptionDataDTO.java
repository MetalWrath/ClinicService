package ru.ancient.clinicservice.exception;

import org.springframework.http.HttpStatus;

public class ExceptionDataDTO {
    private HttpStatus httpStatus;
    private String description;


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
