package ru.ancient.clinicservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ancient.clinicservice.dto.ClinicDTO;
import ru.ancient.clinicservice.dto.DoctorDTO;
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

    @GetMapping("/doc")
    public String getdoc(){
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

        Clinic clinic = new Clinic("Залог Здоровья - Красные Горки", "Москва", "ул. Строителей, 25",
                "84995684895", "8.00-22.00", 0);

        Clinic clinic2 = new Clinic("Залог Здоровья - Южная", "Москва", "Симферопольский бульвар, 17 к.1",
                "84957851532", "8.00-22.00", 0);

        Clinic clinic3 = new Clinic("Залог Здоровья - Белорусская", "Москва", "ул. Лесная д.6",
                "84956632971", "8.00-22.00", 0);

        Clinic clinic4 = new Clinic("Залог Здоровья - Новогиреево", "Москва", "Вешников пер., д. 17",
                "84995802570", "8.00-22.00", 0);

        clinicService.addClinic(clinic);
        clinicService.addClinic(clinic2);
        clinicService.addClinic(clinic3);
        clinicService.addClinic(clinic4);


        return "dffsf";
    }


}
//endpoints:
//        GET /doctors - получение всех докторов.
//        GET /doctors/{id} - получение конкретного доктора по id.
//        POST /doctors  - создание доктора.
//        PUT /doctors/{id} - изменение доктора
//        DELETE /doctors/{id} - удаление доктора