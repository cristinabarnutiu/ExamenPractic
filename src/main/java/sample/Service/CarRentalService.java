package sample.Service;
//to do..
import sample.Domain.Car;
import sample.Domain.CarRental;
import sample.Repository.IRepository;

public class CarRentalService {
    private IRepository<CarRental> repository;

    public void add(String rentId, String carId, double days, double km) {
        CarRental carRental = new CarRental(rentId, carId, days, km);
        repository.upsert(carRental);
    }
}
