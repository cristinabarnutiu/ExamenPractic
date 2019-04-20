package sample.Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CarValidator implements IValidator<Car> {
    /**
     * Validates a car.
     * @param car the car to validate.
     * @throws Exception if the price or km are negative.
     */
    public void validate(Car car) {
            if (car.getPrice() < 0 || car.getKm() < 0) {
                throw new RuntimeException("Price and km must be > 0.");
            }
        }
    }

