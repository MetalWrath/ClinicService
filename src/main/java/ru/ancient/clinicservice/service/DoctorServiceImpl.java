package ru.ancient.clinicservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ancient.clinicservice.dao.DoctorDAO;
import ru.ancient.clinicservice.entity.Doctor;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorDAO doctorDAO;

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
}
