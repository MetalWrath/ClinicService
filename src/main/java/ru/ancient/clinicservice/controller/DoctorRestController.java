package ru.ancient.clinicservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ancient.clinicservice.dto.ClinicDTO;
import ru.ancient.clinicservice.dto.DoctorDTO;
import ru.ancient.clinicservice.dto.ValidateResponseDto;
import ru.ancient.clinicservice.entity.Clinic;
import ru.ancient.clinicservice.entity.Doctor;
import ru.ancient.clinicservice.service.ClinicService;
import ru.ancient.clinicservice.service.DTOClinicAndDoctorParserService;
import ru.ancient.clinicservice.service.DoctorService;
import ru.ancient.clinicservice.service.ValidateService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorRestController {

    @Autowired
    DoctorService doctorService;
    @Autowired
    ClinicService clinicService;

    @Autowired
    DTOClinicAndDoctorParserService dtoClinicAndDoctorParserService;

    @Autowired
    ValidateService validateService;



    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors(){

        return doctorService.getAllDoctors();
    }

    @GetMapping("/doctors/{id}")
    public Doctor getOneDoctorById(@PathVariable int id){

        return doctorService.getOneDoctorById(id);
    }

    @PostMapping("/doctors")
    public Doctor saveDoctor(){

        Clinic clinic = clinicService.getOneClinicById(2);

       //Creating doctor logic


        clinic.addDoctor(null);
        clinicService.updateClinic(clinic);

        return null;
    }

    @PutMapping("/doctors/{id}")
    public Doctor updateDoctor(@PathVariable int id){
        Doctor doctor = doctorService.getOneDoctorById(id);

        //some logic

        return doctorService.updateDoctor(doctor);
    }

    @DeleteMapping("/doctors/{id}")
    public Doctor deleteOneDoctorById(@PathVariable int id){

        return doctorService.deleteDoctor(id);
    }

    @GetMapping("/doc")
    public Doctor getdoc(){

//        DoctorDTO doctorDTO = new DoctorDTO();
//        ClinicDTO clinic = clinicService.getOneClinicDTOById(1);
//        doctorDTO.setLastname("Ivanov");
//        doctorDTO.setFirstname("Sergey");
//        doctorDTO.setMiddlename("Dmitrieevich");
//        doctorDTO.setSpecialization("Urolog");
//        doctorDTO.setPhoneNumber("89165879966");
//        doctorDTO.setSex("male");
//        doctorDTO.setSalary(555555);
//        doctorDTO.setClinicId(1);
//        doctorDTO.setClinic(clinic);
//
//        Doctor doctor = dtoClinicAndDoctorParserService.parseDoctorDTOToDoctor(doctorDTO);
//
//        doctorService.addDoctor(doctor);


        return null;
    }

    @PostMapping("/testdoc")
    public Doctor getDoctorValid(@RequestBody String jsonBody){
        ValidateResponseDto validateResponseDto =
                validateService.validateJson(jsonBody, "DoctorSchema.json");
        if (validateResponseDto.getValidationMessages().size()>0){
            System.out.println("Bad json. very bad json!");
        }else {
            System.out.println(jsonBody);
        }


        return null;
    }

}
//endpoints:
//        GET /doctors - получение всех докторов.
//        GET /doctors/{id} - получение конкретного доктора по id.
//        POST /doctors  - создание доктора.
//        PUT /doctors/{id} - изменение доктора
//        DELETE /doctors/{id} - удаление доктора