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
    DTOClinicAndDoctorParserService dtoClinicAndDoctorParserService;

    @Override
    @Transactional
    public Doctor getOneDoctorById(int id) {
        Doctor doctor = doctorDAO.getOneDoctorById(id);

        if (doctor == null) {
            throw new DoctorNotFoundByIdException("Doctor with id: " + id + " not found");
        }


        return doctor;
    }

    @Override
    @Transactional
    public List<Doctor> getAllDoctors() {

        return doctorDAO.getAllDoctors();
    }

    @Override
    @Transactional
    public Doctor addDoctor(Doctor doctor) {
        doctorDAO.addDoctor(doctor);

        return doctor;
    }

    @Override
    @Transactional
    public Doctor deleteDoctor(int id) {
        Doctor doctor = doctorDAO.getOneDoctorById(id);
        doctorDAO.deleteDoctor(id);

        return doctor;
    }

    @Override
    @Transactional
    public Doctor updateDoctor(Doctor doctor) {
        doctorDAO.updateDoctor(doctor);

        return doctor;
    }

    @Override
    @Transactional
    public DoctorDTO getOneDoctorDTOById(int id) {
        Doctor doctor = doctorDAO.getOneDoctorById(id);

        if (doctor == null) {
            throw new DoctorNotFoundByIdException("Doctor with id: " + id + " not found");
        }


        return dtoClinicAndDoctorParserService.parseDoctorToDTO(doctor);
    }

    @Override
    @Transactional
    public List<DoctorDTO> getAllDoctorsDTO() {
        List<Doctor> doctorList = doctorDAO.getAllDoctors();
        if (doctorList == null) {
            throw new ListOfDoctorsNotFoundException("List of doctors not found");
        }
        List<DoctorDTO> doctorDTOList = new ArrayList<>();
        for (Doctor doctor : doctorList) {
            doctorDTOList.add(dtoClinicAndDoctorParserService.parseDoctorToDTO(doctor));
        }
        return doctorDTOList;
    }
}
