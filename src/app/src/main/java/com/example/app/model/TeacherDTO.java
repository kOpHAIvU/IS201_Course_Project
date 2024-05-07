package com.example.app.model;

public class TeacherDTO {
    private String idTeacher;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String gender;
    private int salary;
    private int status;

    public TeacherDTO(String id, String fullName, String address, String phoneNumber, String gender, int salary, int status) {
        this.idTeacher = id;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.salary = salary;
        this.status = status;
    }

    public String getIdTeacher() {
        return idTeacher;
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

    public int getSalary() {
        return salary;
    }

    public int getStatus() {
        return status;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
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

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
