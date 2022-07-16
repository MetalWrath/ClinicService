package ru.ancient.clinicservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ancient.clinicservice.entity.Clinic;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ClinicDAOImpl implements ClinicDAO{

    @Autowired
    EntityManager entityManager;

    @Override
    public Clinic getOneClinicById(int id) {
        return entityManager.find(Clinic.class, id);
    }

    @Override
    public List<Clinic> getAllClinics() {
        Query query = entityManager.createQuery("FROM Clinic");

        return (List<Clinic>) query.getResultList();
    }

    @Override
    public Clinic addClinic(Clinic clinic) {
        entityManager.merge(clinic);
        return clinic;
    }

    @Override
    public Clinic deleteClinic(int id) {
         Clinic clinic = entityManager.find(Clinic.class, id);

         Query query = entityManager.createQuery("DELETE FROM Clinic WHERE id=:id");
         query.setParameter("id", id);
         query.executeUpdate();

        return clinic;
    }

    @Override
    public Clinic updateClinic(Clinic clinic) {

        entityManager.merge(clinic);

        return clinic;
    }
}
