package com.example.app.model;

public class StaffDTO {
    private String idStaff;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String type;
    private int status;

    public StaffDTO(String id, String fullName, String address, String phoneNumber, String type, int status) {
        this.idStaff = id;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.status = status;
    }


    public String getIdStaff() {
        return idStaff;
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

    public String getType() {
        return type;
    }

    public int getStatus() {
        return status;
    }

    public void setIdStudent(String idStudent) {
        this.idStaff = idStudent;
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

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
