package Model;

import java.util.Calendar;

public class Exam {

//    private Calendar dateExam;
    private String dateExam;
    private String location; // Địa điểm thi
    private String examType; // Loại bài thi
    private String licenseType; // Loại bằng
    private int numberOfVehicles; // Số lượng xe

    public Exam() {
    }

    public Exam(String dateExam ,String location, String examType, String licenseType, int numberOfVehicles) {
        this.dateExam=dateExam;
        this.location = location;
        this.examType = examType;
        this.licenseType = licenseType;
        this.numberOfVehicles = numberOfVehicles;
    }

    public String getDateExam() {
        return dateExam;
    }

    public void setDateExam(String dateExam) {
        this.dateExam = dateExam;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }


    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }
}
