package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reservation {
    private int reservationNumber;
    private LocalDateTime pickupDateTime;
    private LocalDateTime returnDateTime;
    private String sippCode;
    private Car car;

    public Reservation(int reservationNumber, LocalDateTime pickupDateTime, LocalDateTime returnDateTime, String sippCode) {
        this.reservationNumber = reservationNumber;
        this.pickupDateTime = pickupDateTime;
        this.returnDateTime = returnDateTime;
        this.sippCode = sippCode;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public LocalDateTime getPickupDateTime() {
        return pickupDateTime;
    }

    public void setPickupDateTime(LocalDateTime pickupDateTime) {
        this.pickupDateTime = pickupDateTime;
    }

    public LocalDateTime getReturnDateTime() {
        return returnDateTime;
    }

    public void setReturnDateTime(LocalDateTime returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    public String getSippCode() {
        return sippCode;
    }

    public void setSippCode(String sippCode) {
        this.sippCode = sippCode;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return reservationNumber == that.reservationNumber && Objects.equals(pickupDateTime, that.pickupDateTime) && Objects.equals(returnDateTime, that.returnDateTime) && Objects.equals(sippCode, that.sippCode) && Objects.equals(car, that.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationNumber, pickupDateTime, returnDateTime, sippCode, car);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationNumber=" + reservationNumber +
                ", pickupDateTime=" + pickupDateTime +
                ", returnDateTime=" + returnDateTime +
                ", sippCode='" + sippCode + '\'' +
                ", car=" + car +
                '}';
    }
}