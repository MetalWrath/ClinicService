package ru.ancient.clinicservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ancient.clinicservice.dto.ClinicDTO;
import ru.ancient.clinicservice.dto.DoctorDTO;
import ru.ancient.clinicservice.entity.Clinic;
import ru.ancient.clinicservice.entity.Doctor;

import java.util.ArrayList;
import java.util.List;


public interface DTOClinicAndDoctorParserService {

    public DoctorDTO parseDoctorToDTO(Doctor doctor);
    public Doctor parseDoctorDTOToDoctor(DoctorDTO doctorDTO);
    public ClinicDTO parseClinicToClinicDTO(Clinic clinic);
    public Clinic parseClinicDTOToClinic(ClinicDTO clinicDTO);
    public List<DoctorDTO> parseListDoctorToDoctorDTO(List<Doctor> list);
    public List<Doctor> parseListDoctorDTOToDoctorList(List<DoctorDTO> listDTO);

}
