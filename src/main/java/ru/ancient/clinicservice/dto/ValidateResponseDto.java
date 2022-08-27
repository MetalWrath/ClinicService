package ru.ancient.clinicservice.dto;

import com.networknt.schema.ValidationMessage;
import org.springframework.http.HttpStatus;

import java.util.Set;

public class ValidateResponseDto {

    private Set<ValidationMessage> validationMessages;
    private String description;


    public ValidateResponseDto() {
    }

    public ValidateResponseDto(Set<ValidationMessage> validationMessages, String description) {
        this.validationMessages = validationMessages;
        this.description = description;
    }

    public Set<ValidationMessage> getValidationMessages() {
        return validationMessages;
    }

    public void setValidationMessages(Set<ValidationMessage> validationMessages) {
        this.validationMessages = validationMessages;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
