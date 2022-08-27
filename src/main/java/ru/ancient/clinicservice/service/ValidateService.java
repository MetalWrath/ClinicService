package ru.ancient.clinicservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.ancient.clinicservice.dto.ValidateResponseDto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

@Service
public class ValidateService {

    public ResponseEntity<ValidateResponseDto> validateJson(String jsonBody, String jsonSchemaName){
        try(InputStream is = new FileInputStream(jsonSchemaName)) {
            JsonSchema schema = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V201909).getSchema(is);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(jsonBody);

            Set<ValidationMessage> errors = schema.validate(jsonNode);

            ValidateResponseDto validateResponseDto = new ValidateResponseDto();

            if (errors.size()>0){
                return new ResponseEntity<>(new ValidateResponseDto(errors, ""), HttpStatus.BAD_REQUEST);
            }else {
                return new ResponseEntity<>(new ValidateResponseDto(errors, ""), HttpStatus.OK);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
