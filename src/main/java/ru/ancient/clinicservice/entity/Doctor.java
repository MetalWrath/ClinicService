package ru.ancient.clinicservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "middlename")
    private String middlename;
    @Column(name = "specialization")
    private String specialization;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "sex")
    private String sex;
    @Column(name = "salary")
    private int salary;
    @Column(name = "clinic_id")
    private int clinicId;


    public Doctor() {
    }

    public Doctor(int id, String lastname, String firstname, String middlename, String specialization, String phoneNumber, String sex, int salary, int clinicId) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.salary = salary;
        this.clinicId = clinicId;
    }

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
}
