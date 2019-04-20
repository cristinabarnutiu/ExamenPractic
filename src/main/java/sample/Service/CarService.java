package sample.Service;

import sample.Domain.Car;
import sample.Domain.CarValidator;
import sample.Repository.IRepository;

import java.util.List;

public class CarService {

    private IRepository<Car> repository;

    /**
     * Constructs a service.
     * @param repository the backing repository.
     */
    public CarService(IRepository<Car> repository) {
        this.repository = repository;
    }

    /**
     * Adds a car with the given fields.
     * @param carId the id - must be unique.
     * @param model the model.
     * @param km the km.
     * @param price the price.
     */
    public void add(String carId, String model, double km, double price) {
        Car car = new Car(carId, model, km, price);
        repository.upsert(car);
    }

    /**
     * Gets the sum of km for a given car.
     * @param carId the given id.
     * @return the sum of km for a car.
     */
    public double getCarKm(String carId) {
        CarValidator validator = new CarValidator();
        Car dummy = new Car(null, null, 0, 0);
        validator.validate(dummy);

        double sumKm = 0;
        for (Car car : repository.getAll()) {
            if (car.getCarId().equals(carId)) {
                sumKm += car.getKm();
            }
        }
        return sumKm;
    }

    /**
     * Gets a list of all invoices.
     * @return a list of all invoices.
     */
    public List<Car> getAll() {
        return repository.getAll();
    }
}
