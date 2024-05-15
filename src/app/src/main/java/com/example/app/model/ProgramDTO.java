package com.example.app.model;

public class ProgramDTO {
    private String idProgram, nameProgram, inputScore, outputScore, content;
    private String speakingScore, writingScore, listeningScore, readingScore;

    public ProgramDTO(String idProgram, String nameProgram, String inputScore,
                      String outputScore, String content, String speakingScore, String writingScore,
                      String listeningScore, String readingScore) {
        this.idProgram = idProgram;
        this.nameProgram = nameProgram;
        this.inputScore = inputScore;
        this.outputScore = outputScore;
        this.content = content;
        this.speakingScore = speakingScore;
        this.writingScore = writingScore;
        this.listeningScore = listeningScore;
        this.readingScore = readingScore;
    }

    public String getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(String idProgram) {
        this.idProgram = idProgram;
    }

    public String getNameProgram() {
        return nameProgram;
    }

    public void setNameProgram(String nameProgram) {
        this.nameProgram = nameProgram;
    }

    public String getInputScore() {
        return inputScore;
    }

    public void setInputScore(String inputScore) {
        this.inputScore = inputScore;
    }

    public String getOutputScore() {
        return outputScore;
    }

    public void setOutputScore(String outputScore) {
        this.outputScore = outputScore;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSpeakingScore() {
        return speakingScore;
    }

    public void setSpeakingScore(String speakingScore) {
        this.speakingScore = speakingScore;
    }

    public String getWritingScore() {
        return writingScore;
    }

    public void setWritingScore(String writingScore) {
        this.writingScore = writingScore;
    }

    public String getListeningScore() {
        return listeningScore;
    }

    public void setListeningScore(String listeningScore) {
        this.listeningScore = listeningScore;
    }

    public String getReadingScore() {
        return readingScore;
    }

    public void setReadingScore(String readingScore) {
        this.readingScore = readingScore;
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
                '}';
    }
}
