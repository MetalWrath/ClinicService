package ru.ancient.clinicservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ancient.clinicservice.entity.Clinic;
import ru.ancient.clinicservice.entity.Doctor;
import ru.ancient.clinicservice.service.ClinicService;
import ru.ancient.clinicservice.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorRestController {

    @Autowired
    DoctorService doctorService;
    @Autowired
    ClinicService clinicService;



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


}
//endpoints:
//        GET /doctors - получение всех докторов.
//        GET /doctors/{id} - получение конкретного доктора по id.
//        POST /doctors  - создание доктора.
//        PUT /doctors/{id} - изменение доктора
//        DELETE /doctors/{id} - удаление доктора