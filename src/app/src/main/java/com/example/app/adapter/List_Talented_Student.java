package com.example.app.adapter;

public class List_Talented_Student {
    String studentName, phoneNumber, gender, address, state, appointmentNumber;

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

    public List_Talented_Student(String studentName, String phoneNumber, String gender, String address, String state, String appointmentNumber) {
        this.studentName = studentName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.state = state;
        this.appointmentNumber = appointmentNumber;
    }
}
