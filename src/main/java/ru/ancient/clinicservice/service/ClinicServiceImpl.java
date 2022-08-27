package ru.ancient.clinicservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ancient.clinicservice.dao.ClinicDAO;
import ru.ancient.clinicservice.dto.ClinicDTO;
import ru.ancient.clinicservice.entity.Clinic;
import ru.ancient.clinicservice.exception.ClinicNotFoundByIdException;
import ru.ancient.clinicservice.exception.ListOfClinicsNotFoundException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    ClinicDAO clinicDAO;

    @Autowired
    DTOClinicAndDoctorParserService dtoClinicAndDoctorParserService;

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

    @Override
    public ClinicDTO getOneClinicDTOById(int id) {

        Clinic clinic = getOneClinicById(id);
        if (clinic == null) {
            throw new ClinicNotFoundByIdException("Clinic with id: " + id + " not found");
        }
        return dtoClinicAndDoctorParserService.parseClinicToClinicDTO(clinic);
    }

    @Override
    public List<ClinicDTO> getAllClinicDTO() {
        List<Clinic> clinicList = getAllClinics();
        if (clinicList == null) {
            throw new ListOfClinicsNotFoundException("List of clinics not found");
        }
        List<ClinicDTO> clinicDTOList = new ArrayList<>();
        for (Clinic clinic : clinicList) {
            clinicDTOList.add(dtoClinicAndDoctorParserService.parseClinicToClinicDTO(clinic));
        }
        return clinicDTOList;
    }

}


