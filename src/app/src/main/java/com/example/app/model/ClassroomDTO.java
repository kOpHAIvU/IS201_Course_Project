package com.example.app.model;

public class ClassroomDTO {
    String classID, className, level, lectureName, schoolTime, tuition, roomID, programID, staffID;

    public String getClassID() {
        return classID;
    }

    public String getClassName() {
        return className;
    }

    public String getLevel() {
        return level;
    }

    public String getLectureName() {
        return lectureName;
    }

    public String getSchoolTime() {
        return schoolTime;
    }

    public String getTuition() {
        return tuition;
    }

    public String getRoomID() {
        return roomID;
    }

    public String getProgramID() {
        return programID;
    }

    public String getStaffID() {
        return staffID;
    }

    public ClassroomDTO(String classID, String className, String level, String lectureName, String schoolTime, String tuition, String roomID, String programID, String staffID) {
        this.classID = classID;
        this.className = className;
        this.level = level;
        this.lectureName = lectureName;
        this.schoolTime = schoolTime;
        this.tuition = tuition;
        this.roomID = roomID;
        this.programID = programID;
        this.staffID = staffID;
    }
}
