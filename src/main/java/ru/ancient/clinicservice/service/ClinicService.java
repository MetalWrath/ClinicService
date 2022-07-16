package ru.ancient.clinicservice.service;


import ru.ancient.clinicservice.entity.Clinic;

import java.util.List;

public interface ClinicService {

    Clinic getOneClinicById(int id);

    List<Clinic> getAllClinics();

    Clinic addClinic(Clinic clinic);

    Clinic deleteClinic(int id);

    Clinic updateClinic(Clinic clinic);


}
