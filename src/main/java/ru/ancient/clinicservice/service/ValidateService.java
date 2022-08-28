package ru.ancient.clinicservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;;
import org.springframework.stereotype.Service;
import ru.ancient.clinicservice.dto.ValidateResponseDto;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

@Service
@PropertySource("classpath:application.properties")
public class ValidateService {

    @Value("${path.csv}")
    private String path;

    public ValidateResponseDto validateJson(String jsonBody, String jsonSchemaName){
        System.out.println(path+jsonSchemaName);
        try(InputStream is = new FileInputStream(path+jsonSchemaName)) {
            JsonSchema schema = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4).getSchema(is);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(jsonBody);

            Set<ValidationMessage> errors = schema.validate(jsonNode);

            return new ValidateResponseDto(errors, "");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
