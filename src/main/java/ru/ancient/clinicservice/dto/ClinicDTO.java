package ru.ancient.clinicservice.dto;

import ru.ancient.clinicservice.entity.Doctor;


import java.util.List;

public class ClinicDTO {

    private int id;
    private String name;
    private String city;
    private String address;
    private String callNumber;
    private String workTime;
    private int doctorCont;
    private List<DoctorDTO> doctorList;


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

    public List<DoctorDTO> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<DoctorDTO> doctorList) {
        this.doctorList = doctorList;
    }
}
