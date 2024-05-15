package com.example.app.model;

public class CertificateDTO {
    private String idCertificate, name, content,  minimumScore, status;
    public CertificateDTO(String idCertificate, String name, String content, String minimumScore, String status) {
        this.idCertificate = idCertificate;
        this.name = name;
        this.content = content;
        this.minimumScore = minimumScore;
        this.status = status;
    }

    public String getIdCertificate() {
        return idCertificate;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String getMinimumScore() {
        return minimumScore;
    }

    public String getStatus() {
        return status;
    }

    public void setIdCertificate(String idCertificate) {
        this.idCertificate = idCertificate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setMinimumScore(String minimumScore) {
        this.minimumScore = minimumScore;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CertificateDTO{" +
                "idCertificate='" + idCertificate + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", minimumScore='" + minimumScore + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
