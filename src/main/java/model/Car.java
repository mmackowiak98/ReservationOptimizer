package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Car {
    private String plateNumber;
    private String sippCode;
    private String status;
    private LocalDateTime availableFrom;
    private String carModel;

    public Car(String plateNumber, String sippCode, String status, LocalDateTime availableFrom) {
        this.plateNumber = plateNumber;
        this.sippCode = sippCode;
        this.status = status;
        this.availableFrom = availableFrom;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getSippCode() {
        return sippCode;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getAvailableFrom() {
        return availableFrom;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAvailableFrom(LocalDateTime availableFrom) {
        this.availableFrom = availableFrom;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plateNumber='" + plateNumber + '\'' +
                ", sippCode='" + sippCode + '\'' +
                ", status='" + status + '\'' +
                ", availableFrom=" + availableFrom +
                ", carModel='" + carModel + '\'' +
                '}';
    }
}