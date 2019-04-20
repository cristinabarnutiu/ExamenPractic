package sample.Tests;

import org.junit.jupiter.api.Test;
import sample.Domain.Car;
import sample.Domain.CarValidator;

import static org.junit.jupiter.api.Assertions.*;

class CarValidatorTest {

    @Test
    void validateShouldThrowOnlyWhenNecessary() {
/*
        CarValidator validator = new CarValidator();
        Car correctCar = new Car("1", 200, "fdsf", "20.03.2019");
        assertDoesNotThrow(() -> validator.validate(correctCar));

        Car incorrectFormat = new Car("1", 200, "fdsf", "dasda222");
        assertThrows(InvoiceDateFormatException.class, () -> validator.validate(incorrectFormat));

        Car incorrectValues = new Car("1", 200, "fdsf", "56.32.2423");
        assertThrows(InvoiceDateFormatException.class, () -> validator.validate(incorrectValues));

  */  }
}