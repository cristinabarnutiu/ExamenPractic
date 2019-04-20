package sample.Domain;

import java.util.Objects;

public class Car extends Entity {

        private String carId;
        private String model;
        private double km;
        private double price;

        public Car(String carId, String model, double km, double price) {
            super(carId);
            this.model = model;
            this.km = km;
            this.price = price;
        }

        public String getCarId() {
            return carId;
        }

        public void setCarId(String carId) {
            this.carId = carId;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public double getKm() {
            return km;
        }

        public void setKm(double km) {
            this.km = km;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return km == car.km &&
                    Double.compare(car.price, price) == 0 &&
                    Objects.equals(carId, car.carId) &&
                    Objects.equals(model, car.model);
        }

        @Override
        public int hashCode() {
            return Objects.hash(carId, model, km, price);
        }

        @Override
        public String toString() {
            return "Car{" +
                    "carId='" + carId + '\'' +
                    ", model='" + model + '\'' +
                    ", km=" + km +
                    ", price=" + price +
                    '}';
        }
    }