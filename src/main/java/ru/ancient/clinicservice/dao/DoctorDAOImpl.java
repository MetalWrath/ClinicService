package ru.ancient.clinicservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ancient.clinicservice.entity.Doctor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Repository
public class DoctorDAOImpl implements DoctorDAO{

    @Autowired
    EntityManager entityManager;

    @Override
    public Doctor getOneDoctorById(int id) {

        return entityManager.find(Doctor.class, id);
    }

    @Override
    public List<Doctor> getAllDoctors() {

        Query query = entityManager.createQuery("FROM Doctor");

        return (List<Doctor>) query.getResultList();
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        entityManager.merge(doctor);

        return doctor;
    }

    @Override
    public Doctor deleteDoctor(int id) {
        Doctor doctor = entityManager.find(Doctor.class, id);

        Query query = entityManager.createQuery("DELETE FROM Doctor WHERE id=:id");
        query.setParameter("id", id);
        query.executeUpdate();

        return doctor;
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        entityManager.merge(doctor);

        return doctor;
    }
}
