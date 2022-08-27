package ru.ancient.clinicservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clinic")
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;
    @Column(name = "call_number")
    private String callNumber;
    @Column(name = "worktime")
    private String workTime;
    @Column(name = "doctorcount")
    private int doctorCont;
    @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Doctor> doctorList;

    public void addDoctor(Doctor doctor){
        doctorList.add(doctor);
        doctor.setClinic(this);
        this.doctorCont++;
    }

    public void deleteDoctor(Doctor doctor){
        doctorList.remove(doctor);
        doctor.setClinic(null);
        this.doctorCont--;
    }


    public Clinic() {
    }

    public Clinic(String name, String city, String address, String callNumber, String workTime, int doctorCont) {

        this.name = name;
        this.city = city;
        this.address = address;
        this.callNumber = callNumber;
        this.workTime = workTime;
        this.doctorCont = doctorCont;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public int getDoctorCont() {
        return doctorCont;
    }

    public void setDoctorCont(int doctorCont) {
        this.doctorCont = doctorCont;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }
}
