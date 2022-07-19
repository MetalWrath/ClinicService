package ru.ancient.clinicservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ancient.clinicservice.dto.ClinicDTO;
import ru.ancient.clinicservice.entity.Clinic;
import ru.ancient.clinicservice.service.ClinicService;
import ru.ancient.clinicservice.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClinicRestController {

    @Autowired
    ClinicService clinicService;
    @Autowired
    DoctorService doctorService;



    @GetMapping("/clinics")
    public List<ClinicDTO> getAllClinics(){
        return clinicService.getAllClinicDTO();
    }

    @GetMapping("/clinics/{id}")
    public ClinicDTO getOneClinicById(@PathVariable int id){
        return clinicService.getOneClinicDTOById(id);
    }


    @PostMapping("/clinics")
    Clinic saveClinic() {
        return null;
    }



}
//        GET /clinics - получение всех клиник                      +
//        GET /clinics/{id} - получение конкретной клиники по id.   +
//        POST /clinics  - создание клиники.
//        PUT /clinics/{id} - удаление клиники
//        DELETE /clinics/{id} - изменение клиники