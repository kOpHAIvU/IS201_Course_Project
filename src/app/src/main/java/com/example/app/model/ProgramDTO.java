package com.example.app.model;

public class ProgramDTO {
    /*"ID_PROGRAM TEXT PRIMARY KEY, " +
            "NAME TEXT, " +
            "INPUT_SCORE REAL, " +
            "OUTPUT_SCORE REAL, " +
            "CONTENT TEXT, " +
            "SPEAKING_SCORE REAL, " +
            "WRITING_SCORE REAL, " +
            "LISTENING_SCORE REAL, " +
            "READING_SCORE REAL, " +
            "ID_CERTIFICATE REAL, " +
            "STATUS INTEGER," +*/
    private String idProgram, nameProgram, inputScore, outputScore, content;
    private String speakingScore, writingScore, listeningScore, readingScore;
    private String idCertificate;


    public ProgramDTO(String idProgram, String nameProgram, String inputScore,
                      String outputScore, String content, String speakingScore,
                      String writingScore, String listeningScore, String readingScore, String idCertificate) {
        this.idProgram = idProgram;
        this.nameProgram = nameProgram;
        this.inputScore = inputScore;
        this.outputScore = outputScore;
        this.content = content;
        this.speakingScore = speakingScore;
        this.writingScore = writingScore;
        this.listeningScore = listeningScore;
        this.readingScore = readingScore;
        this.idCertificate = idCertificate;
    }

    public String getIdProgram() {
        return idProgram;
    }

    public String getNameProgram() {
        return nameProgram;
    }

    public String getInputScore() {
        return inputScore;
    }

    public String getOutputScore() {
        return outputScore;
    }

    public String getContent() {
        return content;
    }

    public String getSpeakingScore() {
        return speakingScore;
    }

    public String getWritingScore() {
        return writingScore;
    }

    public String getListeningScore() {
        return listeningScore;
    }

    public String getReadingScore() {
        return readingScore;
    }

    public String getIdCertificate() {
        return idCertificate;
    }

    public void setIdProgram(String idProgram) {
        this.idProgram = idProgram;
    }

    public void setNameProgram(String nameProgram) {
        this.nameProgram = nameProgram;
    }

    public void setInputScore(String inputScore) {
        this.inputScore = inputScore;
    }

    public void setOutputScore(String outputScore) {
        this.outputScore = outputScore;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSpeakingScore(String speakingScore) {
        this.speakingScore = speakingScore;
    }

    public void setWritingScore(String writingScore) {
        this.writingScore = writingScore;
    }

    public void setListeningScore(String listeningScore) {
        this.listeningScore = listeningScore;
    }

    public void setReadingScore(String readingScore) {
        this.readingScore = readingScore;
    }

    public void setIdCertificate(String idCertificate) {
        this.idCertificate = idCertificate;
    }

    @Override
    public String toString() {
        return "ProgramDTO{" +
                "idProgram='" + idProgram + '\'' +
                ", nameProgram='" + nameProgram + '\'' +
                ", inputScore='" + inputScore + '\'' +
                ", outputScore='" + outputScore + '\'' +
                ", content='" + content + '\'' +
                ", speakingScore='" + speakingScore + '\'' +
                ", writingScore='" + writingScore + '\'' +
                ", listeningScore='" + listeningScore + '\'' +
                ", readingScore='" + readingScore + '\'' +
                ", idCertificate='" + idCertificate + '\'' +
                '}';
    }
}
