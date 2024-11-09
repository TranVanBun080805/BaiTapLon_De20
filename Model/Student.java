/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author tranb
 */
public class Student {
    private String fullName;// Họ và tên
    private String identityNumber; // CCCD hoặc CMND
    private String registeredLicenseType; // Loại bằng đăng ký thi
    private String examDate; //Ngày thi
    private String result; // Kết quả thi (Đạt, Không đạt, hoặc điểm số)
    
    public Student()
    {
    }
    
    public Student(String fullName, String identityNumber, String registeredLicenseType, String examDate ,String result) {
        this.fullName = fullName;
        this.identityNumber = identityNumber;
        this.registeredLicenseType = registeredLicenseType;
        this.examDate = examDate;
        this.result = result;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getRegisteredLicenseType() {
        return registeredLicenseType;
    }

    public void setRegisteredLicenseType(String registeredLicenseType) {
        this.registeredLicenseType = registeredLicenseType;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }



    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    
}
