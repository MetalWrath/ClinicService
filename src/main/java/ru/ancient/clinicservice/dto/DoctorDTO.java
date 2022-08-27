package ru.ancient.clinicservice.dto;


import ru.ancient.clinicservice.entity.Clinic;


public class DoctorDTO {

    private int id;
    private String lastname;
    private String firstname;
    private String middlename;
    private String specialization;
    private String phoneNumber;
    private String sex;
    private int salary;
    private int clinicId;
    private ClinicDTO clinic;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getClinicId() {
        return clinicId;
    }

    public void setClinicId(int clinicId) {
        this.clinicId = clinicId;
    }

    public ClinicDTO getClinic() {
        return clinic;
    }

    public void setClinic(ClinicDTO clinic) {
        this.clinic = clinic;
        clinic.setDoctorCont(clinic.getDoctorCont()+1);
        clinic.getDoctorList().add(this);
    }
}
