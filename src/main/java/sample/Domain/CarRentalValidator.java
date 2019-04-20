package sample.Domain;


public class CarRentalValidator implements IValidator<CarRental> {
    /**
     * Validates a car rental.
     * @param carRental the carRental to validate.
     * @throws Exception if the dys or km are negative.
     */
    public void validate(CarRental carRental) {
        if (carRental.getDays() < 0 || carRental.getKm() < 0) {
            throw new RuntimeException("Days and km must be > 0.");
        }
    }
}
