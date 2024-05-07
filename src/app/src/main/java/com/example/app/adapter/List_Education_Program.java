package com.example.app.adapter;

public class List_Education_Program {
    String programID, programName, speak, write, read, listen, state, description;

    public String getProgramID() {
        return programID;
    }

    public String getProgramName() {
        return programName;
    }

    public String getSpeak() {
        return speak;
    }

    public String getWrite() {
        return write;
    }

    public String getRead() {
        return read;
    }

    public String getListen() {
        return listen;
    }

    public String getState() {
        return state;
    }

    public String getDescription() {
        return description;
    }

    public List_Education_Program(String programID, String programName, String speak, String write, String read, String listen, String state, String description) {
        this.programID = programID;
        this.programName = programName;
        this.speak = speak;
        this.write = write;
        this.read = read;
        this.listen = listen;
        this.state = state;
        this.description = description;
    }
}
