package ru.ancient.clinicservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ancient.clinicservice.entity.Clinic;
import ru.ancient.clinicservice.service.ClinicService;

@RestController
@RequestMapping("/api")
public class ClinicRestController {

    @Autowired
    ClinicService clinicService;


    @PostMapping("/clinics")
    Clinic addOneClinic() {


        return null;
    }

}
