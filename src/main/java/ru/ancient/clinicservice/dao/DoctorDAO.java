package ru.ancient.clinicservice.dao;

import ru.ancient.clinicservice.entity.Doctor;

import java.util.List;

public interface DoctorDAO {

    Doctor getOneDoctorById(int id);

    List<Doctor> getAllDoctors();

    Doctor addDoctor(Doctor doctor);

    Doctor deleteDoctor(int id);

    Doctor updateDoctor(Doctor doctor);

}
