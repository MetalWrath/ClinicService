package ru.ancient.clinicservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ancient.clinicservice.dao.ClinicDAO;
import ru.ancient.clinicservice.dao.DoctorDAO;
import ru.ancient.clinicservice.dto.ClinicDTO;
import ru.ancient.clinicservice.dto.DoctorDTO;
import ru.ancient.clinicservice.entity.Clinic;
import ru.ancient.clinicservice.entity.Doctor;

import java.util.ArrayList;
import java.util.List;

@Service
public class DTOClinicAndDoctorParserServiceImpl implements DTOClinicAndDoctorParserService{
    @Autowired
    ClinicDAO clinicDAO;
    public DoctorDTO parseDoctorToDTO(Doctor doctor) {

        DoctorDTO doctorDTO = new DoctorDTO();
        ClinicDTO clinic = parseClinicToClinicDTO(clinicDAO.getOneClinicById(doctor.getClinicId()));
        doctorDTO.setId(doctor.getId());
        doctorDTO.setLastname(doctor.getLastname());
        doctorDTO.setFirstname(doctor.getFirstname());
        doctorDTO.setMiddlename(doctor.getLastname());
        doctorDTO.setSpecialization(doctor.getSpecialization());
        doctorDTO.setPhoneNumber(doctor.getPhoneNumber());
        doctorDTO.setSex(doctor.getSex());
        doctorDTO.setSalary(doctor.getSalary());
        doctorDTO.setClinicId(doctor.getClinicId());
        doctorDTO.setClinic(clinic);

        return doctorDTO;
    }

    public Doctor parseDoctorDTOToDoctor(DoctorDTO doctorDTO) {

        Doctor doctor = new Doctor();
        Clinic clinic = clinicDAO.getOneClinicById(doctorDTO.getClinicId());
        doctor.setId(doctorDTO.getId());
        doctor.setLastname(doctorDTO.getLastname());
        doctor.setFirstname(doctorDTO.getFirstname());
        doctor.setMiddlename(doctorDTO.getLastname());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setPhoneNumber(doctorDTO.getPhoneNumber());
        doctor.setSex(doctorDTO.getSex());
        doctor.setSalary(doctorDTO.getSalary());
        doctor.setClinicId(doctorDTO.getClinicId());
        doctor.setClinic(clinic);

        return doctor;
    }


    public ClinicDTO parseClinicToClinicDTO(Clinic clinic) {
        ClinicDTO clinicDTO = new ClinicDTO();

        clinicDTO.setId(clinic.getId());
        clinicDTO.setName(clinic.getName());
        clinicDTO.setCity(clinic.getCity());
        clinicDTO.setAddress(clinic.getAddress());
        clinicDTO.setCallNumber(clinic.getCallNumber());
        clinicDTO.setWorkTime(clinic.getWorkTime());
        clinicDTO.setDoctorCont(clinic.getDoctorCont());
        clinicDTO.setDoctorList(parseListDoctorToDoctorDTO(clinic.getDoctorList()));

        return clinicDTO;
    }

    public Clinic parseClinicDTOToClinic(ClinicDTO clinicDTO) {
        Clinic clinic = new Clinic();

        clinic.setId(clinicDTO.getId());
        clinic.setName(clinicDTO.getName());
        clinic.setCity(clinicDTO.getCity());
        clinic.setAddress(clinicDTO.getAddress());
        clinic.setCallNumber(clinicDTO.getCallNumber());
        clinic.setWorkTime(clinicDTO.getWorkTime());
        clinic.setDoctorCont(clinicDTO.getDoctorCont());
        clinic.setDoctorList(parseListDoctorDTOToDoctorList(clinicDTO.getDoctorList()));

        return clinic;
    }




    public List<DoctorDTO> parseListDoctorToDoctorDTO(List<Doctor> list){
        List<DoctorDTO> listDTO = new ArrayList<>();

        for (Doctor doctor : list){
            listDTO.add(parseDoctorToDTO(doctor));
        }

        return listDTO;
    }

    public List<Doctor> parseListDoctorDTOToDoctorList(List<DoctorDTO> listDTO){
        List<Doctor> list = new ArrayList<>();

        for (DoctorDTO doctorDTO : listDTO){
            list.add(parseDoctorDTOToDoctor(doctorDTO));
        }

        return list;
    }





}
