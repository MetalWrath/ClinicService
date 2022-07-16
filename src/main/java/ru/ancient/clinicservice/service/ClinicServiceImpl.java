package ru.ancient.clinicservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ancient.clinicservice.dao.ClinicDAO;
import ru.ancient.clinicservice.entity.Clinic;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClinicServiceImpl implements ClinicService{

    @Autowired
    ClinicDAO clinicDAO;

    @Override
    @Transactional
    public Clinic getOneClinicById(int id) {
        return clinicDAO.getOneClinicById(id);
    }

    @Override
    @Transactional
    public List<Clinic> getAllClinics() {
        return clinicDAO.getAllClinics();
    }

    @Override
    @Transactional
    public Clinic addClinic(Clinic clinic) {

        clinicDAO.addClinic(clinic);

        return clinic;
    }

    @Override
    @Transactional
    public Clinic deleteClinic(int id) {
        Clinic clinic = clinicDAO.getOneClinicById(id);

        clinicDAO.deleteClinic(id);

        return clinic;
    }

    @Override
    @Transactional
    public Clinic updateClinic(Clinic clinic) {

        clinicDAO.updateClinic(clinic);

        return clinic;
    }
}
