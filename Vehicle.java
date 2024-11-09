/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author tranb
 */
public class Vehicle {
    private String vehicleNumber; // Biển số xe hoặc mã số định danh xe
    private String vehicleInfo; // Hãng xe, loại xe, năm sản xuất
    private String examUsage; // Phục vụ cho bài thi nào
    
    public Vehicle()
    {
        
    }
    
    public Vehicle(String vehicleNumber, String vehicleInfo, String examUsage) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleInfo = vehicleInfo;
        this.examUsage = examUsage;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleInfo() {
        return vehicleInfo;
    }

    public void setVehicleInfo(String vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }

    public String getExamUsage() {
        return examUsage;
    }

    public void setExamUsage(String examUsage) {
        this.examUsage = examUsage;
    }
    
    
}
