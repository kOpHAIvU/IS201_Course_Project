package com.example.app.model;

public class ScheduleDTO {
    private String idSchedule, day, start, end, idClass, idClassroom;

    public ScheduleDTO(String idSchedule, String day, String start, String end,
                       String idClass, String idClassroom) {
        this.idSchedule = idSchedule;
        this.day = day;
        this.start = start;
        this.end = end;
        this.idClass = idClass;
        this.idClassroom = idClassroom;
    }

    public String getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(String idSchedule) {
        this.idSchedule = idSchedule;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getIdClass() {
        return idClass;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }

    public String getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(String idClassroom) {
        this.idClassroom = idClassroom;
    }

    @Override
    public String toString() {
        return "ScheduleDTO{" +
                "idSchedule='" + idSchedule + '\'' +
                ", day='" + day + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", idClass='" + idClass + '\'' +
                ", idClassroom='" + idClassroom + '\'' +
                '}';
    }
}
