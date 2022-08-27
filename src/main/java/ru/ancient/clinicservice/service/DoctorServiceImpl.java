package ru.ancient.clinicservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ancient.clinicservice.dao.ClinicDAO;
import ru.ancient.clinicservice.dao.DoctorDAO;
import ru.ancient.clinicservice.dto.ClinicDTO;
import ru.ancient.clinicservice.dto.DoctorDTO;
import ru.ancient.clinicservice.entity.Clinic;
import ru.ancient.clinicservice.entity.Doctor;
import ru.ancient.clinicservice.exception.DoctorNotFoundByIdException;
import ru.ancient.clinicservice.exception.ListOfDoctorsNotFoundException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorDAO doctorDAO;
    @Autowired
    ClinicDAO clinicDAO;
    @Autowired
    ClinicService clinicService;

    @Override
    @Transactional
    public Doctor getOneDoctorById(int id) {
        return doctorDAO.getOneDoctorById(id);
    }

    @Override
    public List<Doctor> getAllDoctors() {

        return doctorDAO.getAllDoctors();
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        doctorDAO.addDoctor(doctor);

        return doctor;
    }

    @Override
    public Doctor deleteDoctor(int id) {
        Doctor doctor = doctorDAO.getOneDoctorById(id);
        doctorDAO.deleteDoctor(id);

        return doctor;
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        doctorDAO.updateDoctor(doctor);

        return doctor;
    }

    @Override
    public DoctorDTO getOneDoctorDTOById(int id) {
        Doctor doctor = doctorDAO.getOneDoctorById(id);

        if (doctor == null) {
            throw new DoctorNotFoundByIdException("Doctor with id: " + id + " not found");
        }


        return parseDoctorToDTO(doctor);
    }

    @Override
    public List<DoctorDTO> getAllDoctorsDTO() {
        List<Doctor> doctorList = doctorDAO.getAllDoctors();
        if (doctorList == null) {
            throw new ListOfDoctorsNotFoundException("List of doctors not found");
        }
        List<DoctorDTO> doctorDTOList = new ArrayList<>();
        for (Doctor doctor : doctorList) {
            doctorDTOList.add(parseDoctorToDTO(doctor));
        }
        return doctorDTOList;
    }

    @Override
    public DoctorDTO parseDoctorToDTO(Doctor doctor) {

        DoctorDTO doctorDTO = new DoctorDTO();
        ClinicDTO clinic = clinicService.getOneClinicDTOById(doctor.getClinicId());
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

}
