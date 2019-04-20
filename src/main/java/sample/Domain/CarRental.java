package sample.Domain;

import java.util.Objects;

public class CarRental extends Entity {
    private String rentId;
    private String carId;
    private double days, km;

    public CarRental(String rentId, String carId, double days, double km) {
        super(rentId);
        this.carId = carId;
        this.days = days;
        this.km = km;
    }

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public double getDays() {
        return days;
    }

    public void setDays(double days) {
        this.days = days;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CarRental carRental = (CarRental) o;
        return days == carRental.days &&
                km == carRental.km &&
                Objects.equals(rentId, carRental.rentId) &&
                Objects.equals(carId, carRental.carId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rentId, carId, days, km);
    }

    @Override
    public String toString() {
        return "CarRental{" +
                "rentId='" + rentId + '\'' +
                ", carId='" + carId + '\'' +
                ", days=" + days +
                ", km=" + km +
                '}';
    }
}
