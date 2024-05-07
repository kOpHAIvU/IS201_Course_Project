package com.example.app.model;

public class PotentialStudentDTO {
    private String idStudent;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String gender;
    private String level;
    private String numberOfAppointments;
    private int status;

    public PotentialStudentDTO(String idStudent, String fullName, String address, String phoneNumber, String gender, String level, String numberOfAppointments, int status) {
        this.idStudent = idStudent;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.level = level;
        this.numberOfAppointments = numberOfAppointments;
        this.status = status;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setNumberOfAppointments(String numberOfAppointments) {
        this.numberOfAppointments = numberOfAppointments;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getLevel() {
        return level;
    }

    public String getNumberOfAppointments() {
        return numberOfAppointments;
    }

    public int getStatus() {
        return status;
    }
}
