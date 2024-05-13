package com.example.app.model;

public class StaffDTO {
    private String idStaff;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String type;
    private int status;
    private String gender;
    private String birthday;

    public StaffDTO(String idStaff, String fullName, String address, String phoneNumber, String gender, String birthday, String type, int status) {
        this.idStaff = idStaff;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.status = status;
        this.gender = gender;
        this.birthday = birthday;
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
    public String getGender() {
        return gender;
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

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "StaffDTO{" +
                "idStaff='" + idStaff + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", type='" + type + '\'' +
                ", status=" + status +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
