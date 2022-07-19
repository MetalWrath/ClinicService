package ru.ancient.clinicservice.service;


import ru.ancient.clinicservice.dto.ClinicDTO;
import ru.ancient.clinicservice.entity.Clinic;

import java.util.List;

public interface ClinicService {

    Clinic getOneClinicById(int id);

    List<Clinic> getAllClinics();

    Clinic addClinic(Clinic clinic);

    Clinic deleteClinic(int id);

    Clinic updateClinic(Clinic clinic);

    ClinicDTO getOneClinicDTOById(int id);

    List<ClinicDTO> getAllClinicDTO();

    ClinicDTO parseClinicToClinicDTO(Clinic clinic);


}
