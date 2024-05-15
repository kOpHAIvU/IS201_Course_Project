package com.example.app.model;

public class PotentialStudentDTO {
    private String studentName, phoneNumber, gender, address, state, level, appointmentNumber;

    public String getStudentName() {
        return studentName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getAppointmentNumber() {
        return appointmentNumber;
    }

    public String getLevel() {
        return level;
    }

    public PotentialStudentDTO(String studentName, String phoneNumber, String gender, String address, String state, String level, String appointmentNumber) {
        this.studentName = studentName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.state = state;
        this.level = level;
        this.appointmentNumber = appointmentNumber;
    }

    @Override
    public String toString() {
        return "PotentialStudentDTO{" +
                "studentName='" + studentName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", level='" + level + '\'' +
                ", appointmentNumber='" + appointmentNumber + '\'' +
                '}';
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setAppointmentNumber(String appointmentNumber) {
        this.appointmentNumber = appointmentNumber;
    }
}
